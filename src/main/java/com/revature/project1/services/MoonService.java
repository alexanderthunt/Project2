package com.revature.project1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.project1.exceptions.NotFoundException;
import com.revature.project1.models.Moon;
import com.revature.project1.repository.MoonDao;

@Service
public class MoonService {

    @Autowired
    private MoonDao dao;

    public List<Moon> getAllMoons() {

        List<Moon> moons = this.dao.findAll();

        if (!moons.isEmpty()) {
            return moons;
        } else {
            throw new NotFoundException("No moon/s found");
        }
    }

    public List<Moon> getMoonByPlanetId(int id) {

        List<Moon> moons = this.dao.findMoonByMyPlanetId(id);

        if (!moons.isEmpty()) {
            return moons;
        } else {
            throw new NotFoundException("No moon/s found");
        }
    }

    public Moon getMoonByName(String name) {

        Optional<Moon> moon = this.dao.findMoonByName(name);

        if (moon.isPresent()) {
            return moon.get();
        } else {
            throw new NotFoundException("Moon not found");
        }
    }

    public Moon getMoonById(int id) {

        Optional<Moon> moon = this.dao.findById(id);

        if (moon.isPresent()) {
            return moon.get();
        } else {
            throw new NotFoundException("Moon not found");
        }
    }

    public String createMoon(Moon moon) {

        this.dao.createMoon(moon.getName(), moon.getMyPlanetId());
        return "Moon added successfully";
    }

    public String deleteMoonById(int id) {

        if (this.dao.findById(id).isEmpty()) {
            throw new NotFoundException("Moon is not in the database");
        } else {
            this.dao.deleteById(id);
            return "Moon deleted";
        }
    }

}
