package com.example.tp1.service;


import com.example.tp1.modele.Vente;
import com.example.tp1.repository.VenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenteService {
    @Autowired
    VenteRepository venteRepository;

    public void saveVente(Vente vente){
       venteRepository.save(vente);
    }

    public List<Vente> ShowAllVente(){
        return venteRepository.findAll();
    }

    public void showOneVente(int id){
        venteRepository.findById(id);
    }

    public void delete(int id){
         venteRepository.deleteById(id);
    }

}
