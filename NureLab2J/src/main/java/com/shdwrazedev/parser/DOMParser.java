package com.shdwrazedev.parser;

import com.shdwrazedev.metro_upd.Metro;
import org.w3c.dom.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
import java.util.*;

public class DOMParser {
    private static boolean logEnabled = false;

    private static void log(Object o) {
        if (logEnabled) {
            System.out.println(o);
        }
    }

    private Metro.Station parseStation(Node node) {
        Metro.Station station = new Metro.Station();

        NamedNodeMap attributes = node.getAttributes();
        Node idAttribute = attributes.getNamedItem(Const.ATTR_ID);
        if (idAttribute != null) {
            station.setId(Integer.parseInt(idAttribute.getNodeValue()));
        }

        NodeList nodes = node.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            log(item.getLocalName());
            if (Const.TAG_NAME.equals(item.getLocalName())) {
                station.setName(item.getTextContent());
            } else if (Const.TAG_LINE.equals(item.getLocalName())) {
                station.setLine(item.getTextContent());
            } else if (Const.TAG_CITY.equals(item.getLocalName())) {
                station.setCity(item.getTextContent());
            } else if (Const.TAG_NEXTSTATION.equals(item.getLocalName())) {
                station.setNextStation(parseNextStation(item));
            } else if (Const.TAG_PREVSTATION.equals(item.getLocalName())) {
                station.setPrevStation(parsePrevStation(item));
            } else if (Const.TAG_TRANSFERTO.equals(item.getLocalName())) {
                station.setTransferTo(parseTransferTo(item));
            } else if (Const.ATTR_SOMEATTRIBUTE.equals(item.getLocalName())) {
                station.setSomeAttribute(item.getTextContent());
            }
        }
        return station;
    }

    private Metro.Station.NextStation parseNextStation(Node node) {
        Metro.Station.NextStation nextStation = new Metro.Station.NextStation();
        nextStation.setName(node.getTextContent());
        return nextStation;
    }

    private Metro.Station.PrevStation parsePrevStation(Node node) {
        Metro.Station.PrevStation prevStation = new Metro.Station.PrevStation();
        prevStation.setName(node.getTextContent());
        return prevStation;
    }

    private Metro.Station.TransferTo parseTransferTo(Node node) {
        Metro.Station.TransferTo transferTo = new Metro.Station.TransferTo();
        transferTo.setName(node.getTextContent());
        return transferTo;
    }

    public List<Metro.Station> parse(InputStream in, Schema schema) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        dbf.setSchema(schema);
        DocumentBuilder db = dbf.newDocumentBuilder();
        db.setErrorHandler(new DefaultHandler() {
            @Override
            public void error(SAXParseException e) {
                System.err.println(e.getMessage());
            }
        });
        Document root = db.parse(in);

        List<Metro.Station> stations = new ArrayList<>();
        Element e = root.getDocumentElement();
        NodeList xmlStations = e.getElementsByTagName(Const.TAG_STATION);
        for (int i = 0; i < xmlStations.getLength(); i++) {
            stations.add(parseStation(xmlStations.item(i)));
        }
        return stations;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(Const.XSD_FILE));

        System.out.println("--== DOM Parser ==--");
        DOMParser domParser = new DOMParser();
        InputStream in = new FileInputStream(Const.XML_FILE);
        List<Metro.Station> stations = domParser.parse(in, schema);
        System.out.println("====================================");
        System.out.println("Here are the metro stations: \n" + stations);
        System.out.println("====================================");

        in = new FileInputStream(Const.INVALID_XML_FILE);
        stations = domParser.parse(in, schema);
        System.out.println("====================================");
        System.out.println("Here are the metro stations from invalid XML: \n" + stations);
        System.out.println("====================================");
    }
}
