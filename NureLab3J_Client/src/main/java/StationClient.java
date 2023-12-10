import com.sever0x.server.service.*;
import com.sever0x.server.service.metro_upd.Return;
import handler.SecurityHandler;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.handler.Handler;
import jakarta.xml.ws.handler.HandlerResolver;
import jakarta.xml.ws.handler.PortInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StationClient {

    private static final String CLIENT_TOKEN = "clientToken";

    static class ClientHandlerResolver implements HandlerResolver {
        @SuppressWarnings("rawtypes")
        @Override
        public List<Handler> getHandlerChain(PortInfo portInfo) {
            List<Handler> list = new ArrayList<>();
            try {
                list.add(new SecurityHandler());
            } catch (JAXBException e) {
                log.error(e.getMessage());
            }
            return list;
        }
    }

    public static void main(String[] args) {
        try {
            StationClient stationClient = new StationClient();
            stationClient.executeOperations();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeOperations() {
        try {
            StationService port = initializeStationService();

            log.error("_________________Get All Stations_________________");
            displayAllStations(port);

            log.error("_________________Get All Stations BY CITY_________________");
            displayStationsByCity(port, "Харків");

            log.error("____________________ADD STATION_____________________");
            addStation(port);

            log.error("_________________Get All Stations BY line_________________");
            displayStationsByLine(port, "Венеціанська");

            log.error("_________________Get Station by id_________________");
            displayStationById(port, 1);

            log.error("_________________Delete station_______________");
            deleteStation(port, 1);
            displayAllStations(port);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private StationService initializeStationService() {
        StationServiceImplService stationsService = new StationServiceImplService();
        return stationsService.getStationServiceImplPort();
    }

    private void displayAllStations(StationService port) {
        List<Return> stations = port.getAllStations();
        displayStations(stations);
    }

    private void displayStationsByCity(StationService port, String city) {
        List<Return> stationsByCity = port.getStationsByCity(city);
        displayStations(stationsByCity);
    }

    private void addStation(StationService port) throws DAOException_Exception {
        AddStation addStation = new AddStation();
        Return station = createStation();
        addStation.setStation(station);

        AddStationResponse.Return addStationResponse = port.addStation(addStation.getStation());
        log.info(addStationResponse.toString());
    }

    private void displayStationsByLine(StationService port, String line) {
        List<Return> stationsByLine = port.getStationsByLine(line);
        displayStations(stationsByLine);
    }

    private void displayStationById(StationService port, int id) throws DAOException_Exception {
        Return getStationResponse = port.getStation(id);
        log.info(String.valueOf(getStationResponse));
    }

    private void deleteStation(StationService port, int id) throws DAOException_Exception {
        DeleteStation deleteStation = new DeleteStation();
        deleteStation.setId(id);
        DeleteStationResponse deleteStationResponse = port.deleteStation(deleteStation, null, null);
    }

    private Return createStation() {
        Return station = new Return();
        station.setId(99);
        station.setName("Венеція");
        station.setLine("Венеціанська");
        station.setCity("Вінниця");
        return station;
    }

    private void displayStations(List<Return> stations) {
        for (Return station : stations) {
            log.info("STATION: " + station.toString());
        }
    }
}
