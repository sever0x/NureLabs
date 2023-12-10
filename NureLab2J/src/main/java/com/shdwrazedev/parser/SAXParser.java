package com.shdwrazedev.parser;

import com.shdwrazedev.metro_upd.Metro;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SAXParser extends DefaultHandler {
    private static final boolean LOG_ENABLED = false;

    public static void log(Object o) {
        if (LOG_ENABLED) {
            System.out.println(o);
        }
    }

    private String current;
    private List<Metro.Station> stations;
    private Metro.Station station;
    private String nameParent;
    private Metro.Station.NextStation nextStation;
    private Metro.Station.PrevStation prevStation;
    private Metro.Station.TransferTo transferTo;

    public List<Metro.Station> getStations() {
        return stations;
    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
//		throw e; // throw exception if xml not valid
        System.err.println(e.getMessage());
    }

    public List<Metro.Station> parse(InputStream in, Schema schema) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setSchema(schema);
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(in, this);

        return stations;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        current = localName;

        if (Const.TAG_METRO.equals(current)) {
            stations = new ArrayList<>();
        } else if (Const.TAG_STATION.equals(current)) {
            nameParent = Const.TAG_STATION;
            station = new Metro.Station();
            if (attributes.getLength() > 0) {
                station.setId(Integer.parseInt(attributes.getValue("id")));
                station.setSomeAttribute(attributes.getValue("someAttribute"));
            }
        } else if (Const.TAG_NEXTSTATION.equals(current)) {
            nextStation = new Metro.Station.NextStation();
            nameParent = Const.TAG_NEXTSTATION;
        } else if (Const.TAG_PREVSTATION.equals(current)) {
            prevStation = new Metro.Station.PrevStation();
            nameParent = Const.TAG_PREVSTATION;
        } else if (Const.TAG_TRANSFERTO.equals(current)) {
            transferTo = new Metro.Station.TransferTo();
            nameParent = Const.TAG_TRANSFERTO;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length);
        if (value.isBlank()) {
            return;
        }
        if (Const.TAG_NAME.equals(current)) {
            if (Const.TAG_STATION.equals(nameParent)) {
                station.setName(value);
            }
            if (Const.TAG_NEXTSTATION.equals(nameParent)) {
                nextStation.setName(value);
            }
            if (Const.TAG_PREVSTATION.equals(nameParent)) {
                prevStation.setName(value);
            }
            if (Const.TAG_TRANSFERTO.equals(nameParent)) {
                transferTo.setName(value);
            }
        } else if (Const.TAG_LINE.equals(current)) {
            station.setLine(value);
        } else if (Const.TAG_CITY.equals(current)) {
            station.setCity(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (Const.TAG_STATION.equals(localName)) {
            stations.add(station);
            log(current + " " + station);
        } else if (Const.TAG_NEXTSTATION.equals(localName)) {
            station.setNextStation(nextStation);
            log(current + " " + nextStation);
        } else if (Const.TAG_PREVSTATION.equals(localName)) {
            station.setPrevStation(prevStation);
            log(current + " " + prevStation);
        } else if (Const.TAG_TRANSFERTO.equals(localName)) {
            station.setTransferTo(transferTo);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Create against validation schema
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File(Const.XSD_FILE));

        System.out.println("--== SAX Parser ==--");
        SAXParser parser = new SAXParser();
        parser.parse(new FileInputStream(Const.XML_FILE), schema);
        List<Metro.Station> orders = parser.getStations();
        System.out.println("====================================");
        System.out.println("Here is the orders: \n" + orders);
        System.out.println("====================================");
        parser.parse(new FileInputStream(Const.INVALID_XML_FILE), schema);
        orders = parser.getStations();
        System.out.println("====================================");
        System.out.println("Here is the invalid orders: \n" + orders);
        System.out.println("====================================");
    }
}