package com.shdwrazedev.parser;

public interface Const {

    String TAG_METRO = "metro";
    String TAG_STATION = "station";
    String ATTR_ID = "id";

    String ATTR_SOMEATTRIBUTE = "someAttribute";
    String TAG_NAME = "name";
    String TAG_LINE ="line";
    String TAG_CITY = "city";
    String TAG_NEXTSTATION = "nextStation";
    String TAG_PREVSTATION = "prevStation";
    String TAG_TRANSFERTO = "transferTo";

    String XML_FILE = "metro_upd.xml";
    String INVALID_XML_FILE = "invalid_metro_upd.xml";
    String XSD_FILE = "metro_upd.xsd";
    Class<?> OBJECT_FACTORY = com.shdwrazedev.metro_upd.ObjectFactory.class;

    String ORDERS_NAMESPACE_URI = "http://shdwrazedev.com/metro_upd";
    String SCHEMA_LOCATION__ATTR_NAME = "schemaLocation";
    String SCHEMA_LOCATION__ATTR_FQN = "xsi:schemaLocation";
    String XSI_SPACE__PREFIX = "xsi";
    String SCHEMA_LOCATION__URI = "http://shdwrazedev.com/metro_upd metro_upd.xsd";

    // validation features
    public static final String FEATURE__TURN_VALIDATION_ON =
            "http://xml.org/sax/features/validation";
    public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON =
            "http://apache.org/xml/features/validation/schema";
}