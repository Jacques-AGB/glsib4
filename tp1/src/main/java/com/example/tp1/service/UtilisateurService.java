package com.example.tp1.service;

import com.example.tp1.modele.Utilisateur;
import com.example.tp1.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void saveUtilisateur(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> ShowAllUtilisateur(){
        return utilisateurRepository.findAll();
    }

    public void showOneUtilisateur(int id){
        utilisateurRepository.findById(id);
    }

    public void delete(int id){
        utilisateurRepository.deleteById(id);
    }
}
