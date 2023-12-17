package com.sever0x.nurelab4.service;

import com.sever0x.nurelab4.model.Station;
import com.sever0x.nurelab4.repository.MetroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetroService {

    private final MetroRepository metroRepository;

    public List<Station> getStations() {
        return metroRepository.findAll();
    }

    public List<Station> getStationsByCity(String city) {
        return metroRepository.findByCity(city);
    }

    public List<Station> getStationsByLine(String line) {
        return metroRepository.findByLine(line);
    }

    public Station getStationById(int id) {
        return metroRepository.findById(id);
    }

    public Station addStation(Station station) {
        return metroRepository.addStation(station);
    }

    public Station updateStation(int id, Station station) {
        return metroRepository.updateStation(id, station);
    }

    public List<String> getAllCities() {
        return metroRepository.getAllCities();
    }

    public List<String> getAllLines() {
        return metroRepository.getAllLines();
    }

    public List<Station> getByCityAndLine(String city, String line) {
        return metroRepository.findByCityAndLine(city, line);
    }

    public void deleteStation(int id) {
        metroRepository.deleteStation(id);
    }
}
