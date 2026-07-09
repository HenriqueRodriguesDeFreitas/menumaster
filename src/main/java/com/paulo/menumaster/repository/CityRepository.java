package com.paulo.menumaster.repository;

import com.paulo.menumaster.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
}
