package com.sever0x.server.service;

import com.sever0x.model.entity.Metro;
import com.sever0x.server.dao.DAOException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import java.util.Collection;

@WebService
public interface StationService {

    @WebMethod()
    @WebResult(targetNamespace = Const.ENTITY_NS)
    Metro.Station getStation(@WebParam(name = "id") int id) throws DAOException;

    @WebMethod()
    Metro.Station addStation(
            @WebParam(name = "station", targetNamespace = Const.ENTITY_NS)
            Metro.Station station
    ) throws DAOException;

    @WebMethod()
    @WebResult(targetNamespace = Const.ENTITY_NS)
    void deleteStation(
            @WebParam(name = "id")
            int id,
            @WebParam(name = "clientToken", header = true)
            String clientToken,
            @WebParam(name = "serverToken", header = true, mode = WebParam.Mode.OUT)
            Holder<String> serverToken
    ) throws DAOException;

    @WebMethod()
    @WebResult(targetNamespace = Const.ENTITY_NS)
    Collection<Metro.Station> getAllStations();

    @WebMethod()
    @WebResult(targetNamespace = Const.ENTITY_NS)
    Collection<Metro.Station> getStationsByLine(@WebParam(name = "line") String line);

    @WebMethod()
    @WebResult(targetNamespace = Const.ENTITY_NS)
    Collection<Metro.Station> getStationsByCity(@WebParam(name = "city") String city);
}
