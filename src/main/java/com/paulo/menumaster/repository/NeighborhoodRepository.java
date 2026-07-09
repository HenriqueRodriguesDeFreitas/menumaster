package com.paulo.menumaster.repository;

import com.paulo.menumaster.model.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NeighborhoodRepository extends JpaRepository<Neighborhood, UUID> {
}
