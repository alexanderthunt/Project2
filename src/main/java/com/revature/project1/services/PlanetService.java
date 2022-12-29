package com.revature.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project1.exceptions.NotFoundException;
import com.revature.project1.models.Planet;
import com.revature.project1.repository.PlanetDao;

@Service
public class PlanetService {

    @Autowired
    private PlanetDao dao;

    public List<Planet> getAllPlanets() {

        List<Planet> planets = this.dao.findAll();

        if (!planets.isEmpty()) {
            return planets;
        } else {
            throw new NotFoundException("No planets in the database");
        }
    }

    public Planet getPlanetByName(String name) {

        Optional<Planet> planet = this.dao.findPlanetByName(name);

        if (planet.isPresent()) {
            return planet.get();
        } else {
            throw new NotFoundException("Planet not found");
        }
    }

    public Planet getPlanetById(int id) {

        Optional<Planet> planet = this.dao.findById(id);

        if (planet.isPresent()) {
            return planet.get();
        } else {
            throw new NotFoundException("Planet not found");
        }
    }

    public String createPlanet(Planet planet) {

        this.dao.createPlanet(planet.getName(), planet.getOwnerId());
        return "Planet added successfully";
    }

    public String deletePlanetById(int id) {

        if (this.dao.findById(id).isEmpty()) {
            throw new NotFoundException("Planet is not in the database");
        } else {
            this.dao.deleteById(id);
            return "Planet deleted";
        }
    }

}
