package com.sever0x.server.dao;

import com.sever0x.dbtable.DBTable;
import com.sever0x.dbtable.DBTableFactory;
import com.sever0x.dbtable.Filter;
import com.sever0x.model.entity.Metro;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class StationDAOInMemoryImpl implements StationDAO {

    DBTable<Metro.Station> stations = DBTableFactory.instance();

    private static StationDAOInMemoryImpl instance;

    public StationDAOInMemoryImpl() throws DAOException {
        initStations();
    }

    public static synchronized StationDAOInMemoryImpl instance() throws DAOException {
        if (instance == null) {
            instance = new StationDAOInMemoryImpl();
        }
        return instance;
    }

    @Override
    public synchronized Metro.Station addStation(Metro.Station station) throws DAOException {
        if (station == null) {
            throw new IllegalArgumentException("Station can not be a null");
        }
        stations.insert(station);
        return station;
    }

    @Override
    public synchronized void deleteStation(int id) throws DAOException {
        try {
            stations.delete(id);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public synchronized Metro.Station updateStation(int id, Metro.Station updStation) throws DAOException {
        if (updStation == null) {
            throw new NullPointerException("Station is null");
        }
        return stations.update(id, updStation);
    }

    @Override
    public synchronized List<Metro.Station> findAll() {
        return stations.findAll();
    }

    @Override
    public synchronized Metro.Station findById(int id) {
        try {
            return stations.findById(id);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public synchronized List<Metro.Station> findByLine(String line) {
        return stations.filter(line, new Filter<>() {
            @Override
            public boolean accept(Metro.Station item, Object pattern) {
                String p = (String) pattern;
                return item.getLine().equals(p);
            }
        });
    }

    @Override
    public synchronized List<Metro.Station> findByCity(String city) {
        return stations.filter(city, new Filter<>() {
            @Override
            public boolean accept(Metro.Station item, Object pattern) {
                String p = String.valueOf(pattern);
                System.out.println(item);
                return item.getCity().equals(p);
            }
        });
    }

    private void initStations() throws DAOException {
        List<Metro.Station> stationList = Arrays.asList(
                newStation(1, "Південний вокзал", "Холодногірсько-заводська лінія", "Харків",
                        newNextStation("Центральний ринок"),
                        newPrevStation("Холодна гора"),
                        null),
                newStation(4, "Індустріальна", "Холодногірсько-заводська лінія", "Харків",
                        null,
                        newPrevStation("Тракторний завод"),
                        null),
                newStation(6, "Захисників України", "Олексіївська лінія", "Харків",
                        newNextStation("Метробудівників"),
                        newPrevStation("Архітектора Бекетова"),
                        null),
                newStation(8, "Архітектора Бекетова", "Олексіївська лінія", "Харків",
                        newNextStation("Захисників України"),
                        newPrevStation("Держпром"),
                        null),
                newStation(10, "23 Серпня", "Олексіївська лінія", "Харків",
                        newNextStation("Ботанічний сад"),
                        newPrevStation("Олексіївська"),
                        null),
                newStation(11, "Наукова", "Олексіївська лінія", "Харків",
                        newNextStation("Держпром"),
                        newPrevStation("Ботанічний сад"),
                        null),
                newStation(7, "Метробудівників", "Олексіївська лінія", "Харків",
                        null,
                        newPrevStation("Захисників України"),
                        newTransferTo("Спортивна")),
                newStation(14, "Студентська", "Салтівська лінія", "Харків",
                        newNextStation("Героїв Праці"),
                        newPrevStation("Академіка Павлова"),
                        null),
                newStation(17, "Турбоатом", "Холодногірсько-заводська лінія", "Харків",
                        newNextStation("Палац Спорту"),
                        newPrevStation("Завод імені Малишева"),
                        null)
        );

        for (Metro.Station station : stationList) {
            addStation(station);
        }
    }

    private Metro.Station newStation(int id, String name, String line, String city,
                                     Metro.Station.NextStation nextStation, Metro.Station.PrevStation prevStation,
                                     Metro.Station.TransferTo transferTo) {
        Metro.Station station = new Metro.Station();
        station.setId(id);
        station.setName(name);
        station.setLine(line);
        station.setCity(city);
        station.setNextStation(nextStation);
        station.setPrevStation(prevStation);
        station.setTransferTo(transferTo);
        return station;
    }

    private Metro.Station.NextStation newNextStation(String name) {
        Metro.Station.NextStation nextStation = new Metro.Station.NextStation();
        nextStation.setName(name);
        return nextStation;
    }

    private Metro.Station.PrevStation newPrevStation(String name) {
        Metro.Station.PrevStation prevStation = new Metro.Station.PrevStation();
        prevStation.setName(name);
        return prevStation;
    }

    private Metro.Station.TransferTo newTransferTo(String name) {
        Metro.Station.TransferTo transferTo = new Metro.Station.TransferTo();
        transferTo.setName(name);
        return transferTo;
    }
}