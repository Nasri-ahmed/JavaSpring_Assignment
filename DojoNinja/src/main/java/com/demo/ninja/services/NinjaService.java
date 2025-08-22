package com.demo.ninja.services;

import org.springframework.stereotype.Service;

import com.demo.ninja.models.Ninja;
import com.demo.ninja.repositories.NinjaRepository;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepo;

    public NinjaService(NinjaRepository ninjaRepo) {
        this.ninjaRepo = ninjaRepo;
    }

    public Ninja create(Ninja ninja) {
        return ninjaRepo.save(ninja);
    }
}