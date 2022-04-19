package com.example.tp1.service;

import com.example.tp1.modele.Approvisionnement;
import com.example.tp1.repository.ApprovisionnementRepository;
import com.example.tp1.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;
    @Autowired
    private ProduitRepository produitRepository;

    public  void saveApprovisionnement(Approvisionnement approvisionnement){
        if(approvisionnement.getQte()<0)
            throw new RuntimeException("Quantite Invalide");
        approvisionnementRepository.save(approvisionnement);

    }

    public List<Approvisionnement> showApprovisionnement(){
        return approvisionnementRepository.findAll();
    }

    public Approvisionnement ShowOneApprovisionnement(int id){
        return approvisionnementRepository.findById(id).get();
    }

    public void deleteApprovisionnement(int id){
        approvisionnementRepository.deleteById(id);
    }


}
