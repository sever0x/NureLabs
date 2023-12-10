package com.sever0x.nurelab4.repository.impl;

import com.sever0x.nurelab4.model.Station;
import com.sever0x.nurelab4.repository.MetroRepository;

import java.util.List;

public class MetroRepositoryFakeImpl implements MetroRepository {

    @Override
    public List<Station> findAll() {
        return null;
    }

    @Override
    public List<Station> findByCity(String city) {
        return null;
    }

    @Override
    public List<Station> findByLine(String line) {
        return null;
    }

    @Override
    public Station findById(int id) {
        return null;
    }

    @Override
    public Station addStation(Station station) {
        return null;
    }

    @Override
    public Station updateStation(int id, Station station) {
        return null;
    }

    @Override
    public void deleteStation(int id) {

    }
}
