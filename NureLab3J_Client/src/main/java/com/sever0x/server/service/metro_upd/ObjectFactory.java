
package com.sever0x.server.service.metro_upd;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sever0x.server.service.metro_upd package. 
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

    private final static QName _Station_QNAME = new QName("http://service.server.sever0x.com/metro_upd", "station");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sever0x.server.service.metro_upd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Return }
     * 
     */
    public Return createReturn() {
        return new Return();
    }

    /**
     * Create an instance of {@link Return.NextStation }
     * 
     */
    public Return.NextStation createReturnNextStation() {
        return new Return.NextStation();
    }

    /**
     * Create an instance of {@link Return.PrevStation }
     * 
     */
    public Return.PrevStation createReturnPrevStation() {
        return new Return.PrevStation();
    }

    /**
     * Create an instance of {@link Return.TransferTo }
     * 
     */
    public Return.TransferTo createReturnTransferTo() {
        return new Return.TransferTo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/metro_upd", name = "station")
    public JAXBElement<Object> createStation(Object value) {
        return new JAXBElement<Object>(_Station_QNAME, Object.class, null, value);
    }

}
