
package com.sever0x.server.service;

import com.sever0x.server.service.metro_upd.Return;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addStation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addStation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://service.server.sever0x.com/metro_upd}station" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addStation", propOrder = {
    "station"
})
public class AddStation {

    @XmlElement(namespace = "http://service.server.sever0x.com/metro_upd")
    protected Return station;

    /**
     * Gets the value of the station property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Return getStation() {
        return station;
    }

    /**
     * Sets the value of the station property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setStation(Return value) {
        this.station = value;
    }

}
