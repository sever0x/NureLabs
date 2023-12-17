package com.sever0x.nurelab4.repository.impl;

import com.sever0x.nurelab4.model.BranchStation;
import com.sever0x.nurelab4.model.Station;
import com.sever0x.nurelab4.repository.MetroRepository;
import com.sever0x.nurelab4.repository.exception.RepositoryException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MetroRepositoryFakeImpl implements MetroRepository {

    private final Map<Integer, Station> stationsMap;

    public MetroRepositoryFakeImpl() {
        this.stationsMap = initializeStations();
    }

    private Map<Integer, Station> initializeStations() {
        Map<Integer, Station> stations = new HashMap<>();

        stations.put(1, new Station(1, "Південний вокзал", "Харків", "Холодногірсько-заводська лінія", new BranchStation("Центральний ринок"), new BranchStation("Холодна гора"), null));
        stations.put(2, new Station(2, "Індустріальна", "Харків", "Холодногірсько-заводська лінія", null, new BranchStation("Тракторний завод"), null));
        stations.put(3, new Station(3, "Захисників України", "Харків", "Олексіївська лінія", new BranchStation("Метробудівників"), new BranchStation("Архітектора Бекетова"), null));
        stations.put(4, new Station(4, "Троєщина", "Київ", "Троєщинська лінія", null, null, null));

        return stations;
    }

    @Override
    public List<Station> findAll() {
        return new ArrayList<>(stationsMap.values());
    }

    @Override
    public List<Station> findByCity(String city) {
        List<Station> result = new ArrayList<>();
        for (Station station : stationsMap.values()) {
            if (city.equalsIgnoreCase(station.getCity())) {
                result.add(station);
            }
        }
        return result;
    }

    @Override
    public List<Station> findByLine(String line) {
        List<Station> result = new ArrayList<>();
        for (Station station : stationsMap.values()) {
            if (line.equalsIgnoreCase(station.getLine())) {
                result.add(station);
            }
        }
        return result;
    }

    @Override
    public Station findById(int id) {
        if (stationsMap.containsKey(id)) {
            return stationsMap.get(id);
        } else {
            throw new RepositoryException("Not found with id " + id);
        }
    }

    @Override
    public Station addStation(Station station) {
        int newId = generateNewId();
        station.setId(newId);
        stationsMap.put(newId, station);
        return station;
    }

    @Override
    public Station updateStation(int id, Station station) {
        if (stationsMap.containsKey(id)) {
            station.setId(id);
            stationsMap.put(id, station);
            return station;
        } else {
            throw new RepositoryException("Not found with id " + id);
        }
    }

    @Override
    public List<String> getAllCities() {
        List<String> cities = new ArrayList<>();
        for (Station station : stationsMap.values()) {
            if (!cities.contains(station.getCity())) {
                cities.add(station.getCity());
            }
        }
        return cities;
    }

    @Override
    public List<String> getAllLines() {
        List<String> lines = new ArrayList<>();
        for (Station station : stationsMap.values()) {
            if (!lines.contains(station.getLine())) {
                lines.add(station.getLine());
            }
        }
        return lines;
    }

    @Override
    public List<Station> findByCityAndLine(String city, String line) {
        List<Station> result = new ArrayList<>();
        for (Station station : stationsMap.values()) {
            if (city.equalsIgnoreCase(station.getCity()) && line.equalsIgnoreCase(station.getLine())) {
                result.add(station);
            }
        }
        return result;
    }

    @Override
    public void deleteStation(int id) {
        if (stationsMap.containsKey(id)) {
            stationsMap.remove(id);
        } else {
            throw new RepositoryException("Not found with id " + id);
        }
    }

    private int generateNewId() {
        int maxId = stationsMap.keySet().stream().max(Integer::compare).orElse(0);
        return maxId + 1;
    }
}
