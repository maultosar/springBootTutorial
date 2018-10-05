package com.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck,Long> {
}
