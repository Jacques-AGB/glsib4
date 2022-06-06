package com.example.tp1.controller;

import com.example.tp1.modele.LigneVente;
import com.example.tp1.modele.Vente;
import com.example.tp1.repository.LigneVenteRepository;
import com.example.tp1.repository.VenteRepository;
import com.example.tp1.service.ClientService;
import com.example.tp1.service.LigneVenteService;
import com.example.tp1.service.ProduitService;
import com.example.tp1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("ligneVente")
public class LigneVenteController {
    @Autowired
    ProduitService produitService;
    @Autowired
    VenteService venteService;
    @Autowired
    ClientService clientService;
    @Autowired
    LigneVenteService ligneVenteService;

    @Autowired
    VenteRepository venteRepository;

    @GetMapping("/afficher")
    public String Listecommande(Model model){
        model.addAttribute("listeVente", ligneVenteService.showLigneVente());
        return "LigneVente/afficher";
    }


    @GetMapping("/enregistrer")
    public String renseigner(Model model)
    {
        model.addAttribute("listevente",venteService.ShowAllVente());
        model.addAttribute("listProduit",produitService.showProduits());
        model.addAttribute("unevente", ligneVenteService.lect(venteRepository.a()));
        return "Vente/enregistrer";
    }

    @PostMapping("/save")
    public String save(LigneVente ligneVente,Vente vente)
    {
        ligneVente.setVenteId(venteRepository.a());
        ligneVenteService.saveLigneVente(ligneVente);
        return "redirect:/ligneVente/enregistrer";
    }
/*
    @GetMapping("/facture")
    public String fact(@PathVariable("id") int id, Model model, LigneVenteRepository ligneVenteRepository, LigneVente ligneVente){
        model.addAttribute("facture", venteService.ShowAllVente());
        model.addAttribute("unevente", ligneVenteService.lect(id));
        //model.addAttribute("fact", ligneVenteService.b(id));

        int total = 0;
        List<LigneVente> lig =  ligneVenteService.lect(id);
        for(int i = 0; i<lig.size(); i++){
            int quantite = lig.get(i).getQte();
            int prix = lig.get(i).getProduit().getPrix();
            total += quantite * prix;
        }

        model.addAttribute("total", total);
        return "/LigneVente/facture";
    }

    @PostMapping("/facturer")
    public String facto(@ModelAttribute("facture") Vente vente){
        return "redirect:/ligneVente/facture";
    }

*/


}
