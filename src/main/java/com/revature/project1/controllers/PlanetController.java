package com.revature.project1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.project1.models.Planet;
import com.revature.project1.services.PlanetService;

@RestController
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping("/api/planets")
    public ResponseEntity<List<Planet>> getAllPlanets() {

        return new ResponseEntity<>(this.planetService.getAllPlanets(), HttpStatus.OK);
    }

    @GetMapping("/api/planet/{name}")
    public ResponseEntity<Planet> getPlanetByName(@PathVariable String name) {

        return new ResponseEntity<>(this.planetService.getPlanetByName(name), HttpStatus.OK);
    }

    @GetMapping("/api/planet/id/{id}")
    public ResponseEntity<Planet> getPlanetByName(@PathVariable int id) {

        return new ResponseEntity<>(this.planetService.getPlanetById(id), HttpStatus.OK);
    }

    @PostMapping("/api/planet")
    public ResponseEntity<String> createPlanet(@RequestBody Planet planet) {

        return new ResponseEntity<>(this.planetService.createPlanet(planet), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/planet/{id}")
    public ResponseEntity<String> deletePlanet(@PathVariable int id) {

        return new ResponseEntity<>(this.planetService.deletePlanetById(id), HttpStatus.OK);
    }
}
