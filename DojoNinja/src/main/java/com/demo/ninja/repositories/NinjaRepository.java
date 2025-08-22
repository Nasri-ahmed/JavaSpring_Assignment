package com.demo.ninja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ninja.models.Ninja;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
	
}