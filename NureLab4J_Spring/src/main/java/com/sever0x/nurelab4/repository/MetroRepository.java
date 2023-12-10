package com.sever0x.nurelab4.repository;

import com.sever0x.nurelab4.model.Station;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetroRepository {

    List<Station> findAll();

    List<Station> findByCity(String city);

    List<Station> findByLine(String line);

    Station findById(int id);

    Station addStation(Station station);

    Station updateStation(int id, Station station);

    void deleteStation(int id);
}
