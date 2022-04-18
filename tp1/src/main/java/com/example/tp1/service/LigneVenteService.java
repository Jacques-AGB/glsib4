package com.example.tp1.service;

import com.example.tp1.repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneVenteService {
    @Autowired
    LigneVenteRepository ligneVenteRepository;
}
