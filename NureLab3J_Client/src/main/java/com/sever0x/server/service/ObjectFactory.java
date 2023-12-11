
package com.sever0x.server.service;

import javax.xml.namespace.QName;

import handler.SecurityHeader;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sever0x.server.service package. 
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

    private final static QName _DAOException_QNAME = new QName("http://service.server.sever0x.com/", "DAOException");
    private final static QName _AddStation_QNAME = new QName("http://service.server.sever0x.com/", "addStation");
    private final static QName _AddStationResponse_QNAME = new QName("http://service.server.sever0x.com/", "addStationResponse");
    private final static QName _ClientToken_QNAME = new QName("http://service.server.sever0x.com/", "clientToken");
    private final static QName _DeleteStation_QNAME = new QName("http://service.server.sever0x.com/", "deleteStation");
    private final static QName _DeleteStationResponse_QNAME = new QName("http://service.server.sever0x.com/", "deleteStationResponse");
    private final static QName _GetAllStations_QNAME = new QName("http://service.server.sever0x.com/", "getAllStations");
    private final static QName _GetAllStationsResponse_QNAME = new QName("http://service.server.sever0x.com/", "getAllStationsResponse");
    private final static QName _GetStation_QNAME = new QName("http://service.server.sever0x.com/", "getStation");
    private final static QName _GetStationResponse_QNAME = new QName("http://service.server.sever0x.com/", "getStationResponse");
    private final static QName _GetStationsByCity_QNAME = new QName("http://service.server.sever0x.com/", "getStationsByCity");
    private final static QName _GetStationsByCityResponse_QNAME = new QName("http://service.server.sever0x.com/", "getStationsByCityResponse");
    private final static QName _GetStationsByLine_QNAME = new QName("http://service.server.sever0x.com/", "getStationsByLine");
    private final static QName _GetStationsByLineResponse_QNAME = new QName("http://service.server.sever0x.com/", "getStationsByLineResponse");
    private final static QName _ServerToken_QNAME = new QName("http://service.server.sever0x.com/", "serverToken");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sever0x.server.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddStationResponse }
     * 
     */
    public AddStationResponse createAddStationResponse() {
        return new AddStationResponse();
    }

    /**
     * Create an instance of {@link AddStationResponse.Return }
     * 
     */
    public AddStationResponse.Return createAddStationResponseReturn() {
        return new AddStationResponse.Return();
    }

    /**
     * Create an instance of {@link DAOException }
     * 
     */
    public DAOException createDAOException() {
        return new DAOException();
    }

    /**
     * Create an instance of {@link AddStation }
     * 
     */
    public AddStation createAddStation() {
        return new AddStation();
    }

    /**
     * Create an instance of {@link DeleteStation }
     * 
     */
    public DeleteStation createDeleteStation() {
        return new DeleteStation();
    }

    /**
     * Create an instance of {@link DeleteStationResponse }
     * 
     */
    public DeleteStationResponse createDeleteStationResponse() {
        return new DeleteStationResponse();
    }

    /**
     * Create an instance of {@link GetAllStations }
     * 
     */
    public GetAllStations createGetAllStations() {
        return new GetAllStations();
    }

    /**
     * Create an instance of {@link GetAllStationsResponse }
     * 
     */
    public GetAllStationsResponse createGetAllStationsResponse() {
        return new GetAllStationsResponse();
    }

    /**
     * Create an instance of {@link GetStation }
     * 
     */
    public GetStation createGetStation() {
        return new GetStation();
    }

    /**
     * Create an instance of {@link GetStationResponse }
     * 
     */
    public GetStationResponse createGetStationResponse() {
        return new GetStationResponse();
    }

    /**
     * Create an instance of {@link GetStationsByCity }
     * 
     */
    public GetStationsByCity createGetStationsByCity() {
        return new GetStationsByCity();
    }

    /**
     * Create an instance of {@link GetStationsByCityResponse }
     * 
     */
    public GetStationsByCityResponse createGetStationsByCityResponse() {
        return new GetStationsByCityResponse();
    }

    /**
     * Create an instance of {@link GetStationsByLine }
     * 
     */
    public GetStationsByLine createGetStationsByLine() {
        return new GetStationsByLine();
    }

    /**
     * Create an instance of {@link GetStationsByLineResponse }
     * 
     */
    public GetStationsByLineResponse createGetStationsByLineResponse() {
        return new GetStationsByLineResponse();
    }

    /**
     * Create an instance of {@link AddStationResponse.Return.NextStation }
     * 
     */
    public AddStationResponse.Return.NextStation createAddStationResponseReturnNextStation() {
        return new AddStationResponse.Return.NextStation();
    }

    /**
     * Create an instance of {@link AddStationResponse.Return.PrevStation }
     * 
     */
    public AddStationResponse.Return.PrevStation createAddStationResponseReturnPrevStation() {
        return new AddStationResponse.Return.PrevStation();
    }

    /**
     * Create an instance of {@link AddStationResponse.Return.TransferTo }
     * 
     */
    public AddStationResponse.Return.TransferTo createAddStationResponseReturnTransferTo() {
        return new AddStationResponse.Return.TransferTo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DAOException }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "DAOException")
    public JAXBElement<DAOException> createDAOException(DAOException value) {
        return new JAXBElement<DAOException>(_DAOException_QNAME, DAOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStation }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "addStation")
    public JAXBElement<AddStation> createAddStation(AddStation value) {
        return new JAXBElement<AddStation>(_AddStation_QNAME, AddStation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "addStationResponse")
    public JAXBElement<AddStationResponse> createAddStationResponse(AddStationResponse value) {
        return new JAXBElement<AddStationResponse>(_AddStationResponse_QNAME, AddStationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "clientToken")
    public JAXBElement<SecurityHeader> createClientToken(SecurityHeader value) {
        return new JAXBElement<SecurityHeader>(_ClientToken_QNAME, SecurityHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStation }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "deleteStation")
    public JAXBElement<DeleteStation> createDeleteStation(DeleteStation value) {
        return new JAXBElement<DeleteStation>(_DeleteStation_QNAME, DeleteStation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "deleteStationResponse")
    public JAXBElement<DeleteStationResponse> createDeleteStationResponse(DeleteStationResponse value) {
        return new JAXBElement<DeleteStationResponse>(_DeleteStationResponse_QNAME, DeleteStationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStations }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStations }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getAllStations")
    public JAXBElement<GetAllStations> createGetAllStations(GetAllStations value) {
        return new JAXBElement<GetAllStations>(_GetAllStations_QNAME, GetAllStations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStationsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStationsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getAllStationsResponse")
    public JAXBElement<GetAllStationsResponse> createGetAllStationsResponse(GetAllStationsResponse value) {
        return new JAXBElement<GetAllStationsResponse>(_GetAllStationsResponse_QNAME, GetAllStationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStation }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStation }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getStation")
    public JAXBElement<GetStation> createGetStation(GetStation value) {
        return new JAXBElement<GetStation>(_GetStation_QNAME, GetStation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStationResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStationResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getStationResponse")
    public JAXBElement<GetStationResponse> createGetStationResponse(GetStationResponse value) {
        return new JAXBElement<GetStationResponse>(_GetStationResponse_QNAME, GetStationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStationsByCity }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStationsByCity }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getStationsByCity")
    public JAXBElement<GetStationsByCity> createGetStationsByCity(GetStationsByCity value) {
        return new JAXBElement<GetStationsByCity>(_GetStationsByCity_QNAME, GetStationsByCity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStationsByCityResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStationsByCityResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getStationsByCityResponse")
    public JAXBElement<GetStationsByCityResponse> createGetStationsByCityResponse(GetStationsByCityResponse value) {
        return new JAXBElement<GetStationsByCityResponse>(_GetStationsByCityResponse_QNAME, GetStationsByCityResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStationsByLine }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStationsByLine }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getStationsByLine")
    public JAXBElement<GetStationsByLine> createGetStationsByLine(GetStationsByLine value) {
        return new JAXBElement<GetStationsByLine>(_GetStationsByLine_QNAME, GetStationsByLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStationsByLineResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStationsByLineResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "getStationsByLineResponse")
    public JAXBElement<GetStationsByLineResponse> createGetStationsByLineResponse(GetStationsByLineResponse value) {
        return new JAXBElement<GetStationsByLineResponse>(_GetStationsByLineResponse_QNAME, GetStationsByLineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://service.server.sever0x.com/", name = "serverToken")
    public JAXBElement<String> createServerToken(String value) {
        return new JAXBElement<String>(_ServerToken_QNAME, String.class, null, value);
    }

}
