package com.paulo.menumaster.repository;

import com.paulo.menumaster.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRepository extends JpaRepository<State, UUID> {
}
