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

import com.revature.project1.models.Moon;
import com.revature.project1.services.MoonService;

@RestController
public class MoonController {

    @Autowired
    private MoonService moonService;

    @GetMapping("/api/moons")
    public ResponseEntity<List<Moon>> getAllMoons() {

        return new ResponseEntity<>(this.moonService.getAllMoons(), HttpStatus.OK);
    }

    @GetMapping("/api/moon/planet/{id}")
    public ResponseEntity<List<Moon>> getMoonByPlanetId(@PathVariable int id) {

        return new ResponseEntity<>(this.moonService.getMoonByPlanetId(id), HttpStatus.OK);
    }

    @GetMapping("/api/moon/{name}")
    public ResponseEntity<Moon> getMoonByName(@PathVariable String name) {

        return new ResponseEntity<>(this.moonService.getMoonByName(name), HttpStatus.OK);
    }

    @GetMapping("/api/moon/id/{id}")
    public ResponseEntity<Moon> getMoonByName(@PathVariable int id) {

        return new ResponseEntity<>(this.moonService.getMoonById(id), HttpStatus.OK);
    }

    @PostMapping("/api/moon")
    public ResponseEntity<String> createMoon(@RequestBody Moon moon) {

        return new ResponseEntity<>(this.moonService.createMoon(moon), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/moon/{id}")
    public ResponseEntity<String> deleteMoon(@PathVariable int id) {

        return new ResponseEntity<>(this.moonService.deleteMoonById(id), HttpStatus.OK);
    }
}