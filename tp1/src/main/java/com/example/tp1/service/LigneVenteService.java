package com.example.tp1.service;

import com.example.tp1.modele.Client;
import com.example.tp1.modele.LigneVente;
import com.example.tp1.repository.LigneVenteRepository;
import com.example.tp1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneVenteService {
    @Autowired
    LigneVenteRepository ligneVenteRepository;
    @Autowired
    ProduitRepository produitRepository;

    //Enregistrer
    public void saveLigneVente(LigneVente ligneVente){
        ligneVenteRepository.save(ligneVente);
    }
/*
    public void saveLigneVentes(List<LigneVente> ligneVentes){
        for (LigneVente ligneVente: ligneVentes) {
            if(ligneVente.getQte()<0)
                throw new RuntimeException("Quantite invalide");
        }
        ligneVenteRepository.saveAll(ligneVentes);
        for (LigneVente ligneVente: ligneVentes) {
            produitRepository.updateQteProduitVente(-1*ligneVente.getQte(),ligneVente.getProduitId());
        }
    }*/

    //Lister
    public List<LigneVente> showLigneVente(){
        return ligneVenteRepository.findAll();
    }

    public List<LigneVente> lect(int id){
        return ligneVenteRepository.lect(id);
    }

    //Trouver une ligne
    public LigneVente showOneLigneVente(int id){
        return ligneVenteRepository.findById(id).get();
    }

    //Supprimer
    public void deleteLigneVente(int id){
        ligneVenteRepository.deleteById(id);
    }
}
