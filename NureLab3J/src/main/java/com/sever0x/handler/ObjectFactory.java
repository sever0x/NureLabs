package com.sever0x.handler;

import com.sever0x.server.service.Const;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.namespace.QName;

public class ObjectFactory {

    private static final QName _ServerToken_QNAME = new QName(Const.SERVICE_NS, "serverToken");
    private static final QName _ClientToken_QNAME = new QName(Const.SERVICE_NS, "clientToken");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: app
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SecurityHeader }
     *
     */
    public SecurityHeader createSecurityHeader() {
        return new SecurityHeader();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityHeader }{@code >}}
     *
     */
    @XmlElementDecl(namespace = Const.SERVICE_NS, name = "serverToken")
    public JAXBElement<SecurityHeader> createServerToken(SecurityHeader value) {
        return new JAXBElement<SecurityHeader>(_ServerToken_QNAME, SecurityHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecurityHeader }{@code >}}
     *
     */
    @XmlElementDecl(namespace = Const.SERVICE_NS, name = "clientToken")
    public JAXBElement<SecurityHeader> createClientToken(SecurityHeader value) {
        return new JAXBElement<SecurityHeader>(_ClientToken_QNAME, SecurityHeader.class, null, value);
    }

}
