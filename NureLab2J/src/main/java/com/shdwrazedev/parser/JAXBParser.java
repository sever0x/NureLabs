package com.shdwrazedev.parser;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.shdwrazedev.metro_upd.Metro;
import jakarta.xml.bind.*;
import org.xml.sax.SAXException;

import java.io.File;

public class JAXBParser {

    public static Metro loadMetro(final String xmlFileName, final String xsdFileName, Class<?> objectFactory) throws JAXBException, SAXException {
        JAXBContext jc = JAXBContext.newInstance(objectFactory);
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        if (xsdFileName != null) {
            Schema schema = sf.newSchema(new File(xsdFileName));
            unmarshaller.setSchema(schema);

            unmarshaller.setEventHandler(event -> {
                System.err.println("====================================");
                System.err.println(xmlFileName + " не є валідним відповідно до " + xsdFileName + ":\n" + event.getMessage());
                System.err.println("====================================");

                return true;
            });
        }

        return (Metro) unmarshaller.unmarshal(new File(xmlFileName));
    }

    public static void saveMetro(Metro metro, final String xmlFileName, final String xsdFileName, Class<?> objectFactory) throws JAXBException, SAXException {
        JAXBContext jc = JAXBContext.newInstance(objectFactory);
        Marshaller marshaller = jc.createMarshaller();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        if (xsdFileName != null) {
            Schema schema = sf.newSchema(new File(xsdFileName));

            marshaller.setSchema(schema);
            marshaller.setEventHandler(event -> {
                System.err.println("====================================");
                System.err.println(xmlFileName + " не є валідним відповідно до " + xsdFileName + ":\n" + event.getMessage());
                System.err.println("====================================");
                return false;
            });
        }

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, Const.SCHEMA_LOCATION__URI);
        marshaller.marshal(metro, new File(xmlFileName));
    }

    public static void main(String[] args) throws JAXBException, SAXException {
        System.out.println("--== JAXB Parser ==--");

        Metro metro = loadMetro(Const.XML_FILE, Const.XSD_FILE, Const.OBJECT_FACTORY);

        System.out.println("====================================");
        System.out.println("Ось Metro: \n" + metro);
        System.out.println("====================================");

        try {
            saveMetro(metro, Const.XML_FILE + ".jaxb.xml", Const.XSD_FILE, Const.OBJECT_FACTORY);
        } catch (Exception ex) {
            System.err.println("====================================");
            System.err.println("Дерево об'єктів не валідне щодо XSD.");
            System.err.println(ex.getClass().getName());
            System.err.println("====================================");
        }
    }
}
