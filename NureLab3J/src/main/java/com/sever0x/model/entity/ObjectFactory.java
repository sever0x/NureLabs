//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.11.01 at 01:08:39 PM EET 
//


package com.sever0x.model.entity;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.shdwrazedev.metro_upd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.shdwrazedev.metro_upd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Metro }
     * 
     */
    public Metro createMetro() {
        return new Metro();
    }

    /**
     * Create an instance of {@link Metro.Station }
     * 
     */
    public Metro.Station createMetroStation() {
        return new Metro.Station();
    }

    /**
     * Create an instance of {@link Metro.Station.NextStation }
     * 
     */
    public Metro.Station.NextStation createMetroStationNextStation() {
        return new Metro.Station.NextStation();
    }

    /**
     * Create an instance of {@link Metro.Station.PrevStation }
     * 
     */
    public Metro.Station.PrevStation createMetroStationPrevStation() {
        return new Metro.Station.PrevStation();
    }

    /**
     * Create an instance of {@link Metro.Station.TransferTo }
     * 
     */
    public Metro.Station.TransferTo createMetroStationTransferTo() {
        return new Metro.Station.TransferTo();
    }

}
