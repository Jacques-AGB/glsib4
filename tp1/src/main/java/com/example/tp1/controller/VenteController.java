package com.example.tp1.controller;


import com.example.tp1.Authentication.MyUserDetails;
import com.example.tp1.modele.Produit;
import com.example.tp1.modele.Vente;
import com.example.tp1.service.ClientService;
import com.example.tp1.service.MyUserDetailsService;
import com.example.tp1.service.ProduitService;
import com.example.tp1.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("vente")
public class VenteController {
   @Autowired
    ProduitService produitService;
    @Autowired
    VenteService venteService;
    @Autowired
    ClientService clientService;

    @Autowired
    MyUserDetailsService myUserDetailsService;
/*
    @GetMapping("/afficher")
    public String ShowVente(Model model){
        model.addAttribute("ListVentes",venteService.ShowAllVente());
        return "Vente/TableVente";
    }
    @GetMapping("/afficher2")
    public String ShowVente2(Model model){
        model.addAttribute("listproduits",produitService.showProduits());
        //model.addAttribute("ListVentes",venteService.ShowAllVente());
        return "Vente/showProduit";
    }
*/
@GetMapping("/afficher")
public String Listevente(Model model){
    model.addAttribute("ListVentes", venteService.ShowAllVente());
    return "vente/TableVente";
}


    @GetMapping("/enregistrer")
    public String renseigner(Model model)
    {
        model.addAttribute("listProduit",produitService.showProduits());
        model.addAttribute("utilisateur",myUserDetailsService.showUser());
        model.addAttribute("client", clientService.showClient());

        return "Vente/enregistrer";
    }

    @PostMapping("/save")
    public String save(Model model,Vente vente/*MyUserDetails myUserDetails*/)
    {
        model.addAttribute("listProduit",produitService.showProduits());
        vente.setDateVente(LocalDate.now());
        vente.setUser_id(2);
        venteService.saveVente(vente);
        return "redirect:/vente/enregistrer";
    }

    @GetMapping("/SelectClient")
    public String SelectClient(Model model){
        model.addAttribute("listClient",clientService.showClient());
        return "Vente/SelectClt";
    }

/*
    @PostMapping("/save")
    public String saveVente(Vente vente)
    {
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        return "redirect:/vente/afficher2";
    }
*/

    @GetMapping("/vendre/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("listClient",clientService.showClient());
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        System.out.println("id = "+produitService.showOneProduit(id));
        return "vente/formVente";
    }
    @GetMapping("/VendeurDash")
    public String VendeurDash(Model model){
        model.addAttribute("Produits",produitService.showProduits());
        return "VendeurDash";
    }

}
