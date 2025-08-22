package com.demo.ninja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.ninja.models.Dojo;
import com.demo.ninja.repositories.DojoRepository;

@Service
public class DojoService {

    private final DojoRepository dojoRepo;

    public DojoService(DojoRepository dojoRepo) {
        this.dojoRepo = dojoRepo;
    }

    public Dojo create(Dojo dojo) {
        return dojoRepo.save(dojo);
    }

    public Dojo findById(Long id) {
        Optional<Dojo> optionalDojo = dojoRepo.findById(id);
        return optionalDojo.orElse(null);
    }

    public List<Dojo> findAll() {
        return dojoRepo.findAll();
    }
}