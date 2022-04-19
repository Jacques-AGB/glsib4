package com.example.tp1.service;

import com.example.tp1.modele.Client;
import com.example.tp1.modele.LigneVente;
import com.example.tp1.repository.LigneVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneVenteService {
    @Autowired
    LigneVenteRepository ligneVenteRepository;

    //Enregistrer
    public void SaveLigneVente(LigneVente ligneVente){
        ligneVenteRepository.save(ligneVente);
    }

    //Lister
    public List<LigneVente> showLigneVente(){
        return ligneVenteRepository.findAll();
    }

    //Trouver un client
    public LigneVente showOneLigneVente(int id){
        return ligneVenteRepository.findById(id).get();
    }

    //Supprimer
    public void deleteLigneVente(int id){
        ligneVenteRepository.deleteById(id);
    }
}
