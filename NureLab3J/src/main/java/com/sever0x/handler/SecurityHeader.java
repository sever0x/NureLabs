package com.sever0x.handler;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "securityHeader", propOrder = {
        "token"
})
public class SecurityHeader {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String token;

    public SecurityHeader() {
        // default constructor
    }

    public SecurityHeader(String token) {
        this.token = token;
    }

    /**
     * Gets the value of the token property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setToken(String value) {
        this.token = value;
    }

}
