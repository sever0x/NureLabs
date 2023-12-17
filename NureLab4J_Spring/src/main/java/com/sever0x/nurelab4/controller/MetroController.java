package com.sever0x.nurelab4.controller;

import com.sever0x.nurelab4.model.Station;
import com.sever0x.nurelab4.service.MetroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MetroController {

    private final MetroService metroService;

    @GetMapping(value = "/stations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Station> getStations(@RequestParam(required = false) String city,
                                     @RequestParam(required = false) String line) {
        if (city != null && line != null) {
            return metroService.getByCityAndLine(city, line);
        } else if (city != null) {
            return metroService.getStationsByCity(city);
        } else if (line != null) {
            return metroService.getStationsByLine(line);
        } else {
            return metroService.getStations();
        }
    }

    @GetMapping(value = "/stations/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Station getStationById(@PathVariable int id) {
        return metroService.getStationById(id);
    }

    @PostMapping(value = "/stations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Station addStation(@RequestBody @Valid Station station) {
        return metroService.addStation(station);
    }

    @PatchMapping(value = "/stations/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Station updateStation(@PathVariable int id, @RequestBody @Valid Station station) {
        return metroService.updateStation(id, station);
    }

    @PutMapping(value = "/stations/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Station replaceStation(@PathVariable int id, @RequestBody @Valid Station station) {
        return metroService.updateStation(id, station);
    }

    @DeleteMapping(value = "/stations/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void deleteStation(@PathVariable int id) {
        metroService.deleteStation(id);
    }

    @GetMapping(value = "/cities", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<String> getAllCities() {
        return metroService.getAllCities();
    }

    @GetMapping(value = "/lines", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<String> getAllLines() {
        return metroService.getAllLines();
    }
}
