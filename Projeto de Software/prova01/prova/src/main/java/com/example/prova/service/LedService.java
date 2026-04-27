package com.example.prova.service;

import com.example.prova.model.Led;
import com.example.prova.repository.LedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LedService {
    private final LedRepository ledRepository;

    public LedService(LedRepository ledRepository) {
        this.ledRepository = ledRepository;
    }

    public void salvar(Led led) {
        ledRepository.save(led);
    }

    public List<Led> listarHistorico(){
        return ledRepository.findAll();
    }


}
