package com.revature.project1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.project1.models.Moon;

public interface MoonDao extends JpaRepository<Moon, Integer> {

    Optional<Moon> findMoonByName(String name);

    @Query(value = "select * from moons where myplanetid = :myPlanetId", nativeQuery = true)
    List<Moon> findMoonByMyPlanetId(@Param("myPlanetId") int myPlanetId);

    @Modifying
    @Transactional
    @Query(value = "insert into Moons values(default, :name, :myPlanetId)", nativeQuery = true)
    void createMoon(@Param("name") String name, @Param("myPlanetId") int myPlanetId);

}
