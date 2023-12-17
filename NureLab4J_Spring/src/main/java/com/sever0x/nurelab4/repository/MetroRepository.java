package com.sever0x.nurelab4.repository;

import com.sever0x.nurelab4.model.Station;

import java.util.List;

public interface MetroRepository {

    List<Station> findAll();

    List<Station> findByCity(String city);

    List<Station> findByLine(String line);

    Station findById(int id);

    Station addStation(Station station);

    Station updateStation(int id, Station station);

    List<String> getAllCities();

    List<String> getAllLines();

    List<Station> findByCityAndLine(String city, String line);

    void deleteStation(int id);
}
