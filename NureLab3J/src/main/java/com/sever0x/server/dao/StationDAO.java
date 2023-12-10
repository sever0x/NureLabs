package com.sever0x.server.dao;

import com.sever0x.model.entity.Metro;

import java.util.List;

public interface StationDAO {

    Metro.Station addStation(Metro.Station station) throws DAOException;

    void deleteStation(int id) throws DAOException;

    Metro.Station updateStation(int id, Metro.Station updStation) throws DAOException;

    List<Metro.Station> findAll();

    Metro.Station findById(int id);

    List<Metro.Station> findByLine(String line);

    List<Metro.Station> findByCity(String city);
}
