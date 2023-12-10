package com.sever0x.nurelab4.controller;

import com.sever0x.nurelab4.model.Station;
import com.sever0x.nurelab4.service.MetroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MetroController {

    private final MetroService metroService;

    @GetMapping(value = "/stations", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Station> getStations() {
        return metroService.getStations();
    }
}
