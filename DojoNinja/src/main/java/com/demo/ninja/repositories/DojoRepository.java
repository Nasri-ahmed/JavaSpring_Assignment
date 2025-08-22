package com.demo.ninja.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ninja.models.Dojo;

@Repository
public interface DojoRepository extends JpaRepository<Dojo, Long> {
	
	
}