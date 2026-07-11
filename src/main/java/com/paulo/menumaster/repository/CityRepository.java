package com.paulo.menumaster.repository;

import com.paulo.menumaster.model.City;
import com.paulo.menumaster.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    @Query("""
        SELECT c FROM City c WHERE  FUNCTION('unaccent', LOWER(c.name)) = FUNCTION('unaccent', LOWER(:name)) AND c.state = :state
        """)
    boolean existsByNameignoreCaseAndState(@Param("name") String name, @Param("state") State state);
}
