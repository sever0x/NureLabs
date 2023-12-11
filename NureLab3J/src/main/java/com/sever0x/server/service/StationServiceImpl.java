package com.sever0x.server.service;

import com.sever0x.model.entity.Metro;
import com.sever0x.server.dao.DAOException;
import com.sever0x.server.dao.StationDAO;
import com.sever0x.server.dao.StationDAOInMemoryImpl;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import java.util.List;

//@HandlerChain(file = "security_handler.xml")
@WebService(
        endpointInterface = "com.sever0x.server.service.StationService"
)
public class StationServiceImpl implements StationService {

    private static final StationDAO stationDAO;

    static {
        try {
            stationDAO = StationDAOInMemoryImpl.instance();
        } catch (DAOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Metro.Station getStation(int id) throws DAOException {
        return stationDAO.findById(id);
    }

    @Override
    public Metro.Station addStation(Metro.Station station) throws DAOException {
        return stationDAO.addStation(station);
    }

    @Override
    public void deleteStation(int id, String clientToken, Holder<String> serverToken) throws DAOException {
        stationDAO.deleteStation(id);
    }

    @Override
    public List<Metro.Station> getAllStations() {
        return stationDAO.findAll();
    }

    @Override
    public List<Metro.Station> getStationsByLine(String line) {
        return stationDAO.findByLine(line);
    }

    @Override
    public List<Metro.Station> getStationsByCity(String city) {
        return stationDAO.findByCity(city);
    }
}
