package com.revature.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.revature.project1.models.Planet;

public interface PlanetDao extends JpaRepository<Planet, Integer> {

    Optional<Planet> findPlanetByName(String name);

    @Modifying
    @Transactional
    @Query(value = "insert into planets values(default, :name, :ownerId)", nativeQuery = true)
    void createPlanet(@Param("name") String name, @Param("ownerId") int ownerId);

}
