package com.example.tp1.controller;


import com.example.tp1.modele.Vente;
import com.example.tp1.service.ProduitService;
import com.example.tp1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("vente")
public class VenteController {
    @Autowired
    ProduitService produitService;
    @Autowired
    VenteService venteService;

    @GetMapping("/afficher")
    public String ShowVente(Model model){
        model.addAttribute("ListVentes",venteService.ShowAllVente());
        return "vente/showVente";
    }

    @PostMapping("/save")
    public String saveVente(Vente vente)
    {
        //ajout
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        produitService.updateProduitVente(vente.getProduit_id(), vente.getQte());
        return "redirect:/produits/afficher";
    }

    @GetMapping("/vendre/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        System.out.println("id = "+produitService.showOneProduit(id));
        return "vente/formVente";
    }



}
