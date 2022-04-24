package com.example.tp1.controller;

import com.example.tp1.modele.Approvisionnement;
import com.example.tp1.modele.Produit;
import com.example.tp1.service.ApprovisionnementService;
import com.example.tp1.service.CategorieService;
import com.example.tp1.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/approvisionnement")
public class ApprovisionnementController {
    @Autowired
    ApprovisionnementService approvisionnementService;
    @Autowired
    ProduitService produitService;



    @GetMapping("afficher")
    public  String ShowListApprovisionnement(Model model)
    {

        model.addAttribute("listApprovisionnement",approvisionnementService.showApprovisionnement());
        return ("Approvisionnement/showApprovisionnement");
    }

    @PostMapping("/save")
    public String saveApprovisionnement(Approvisionnement approvisionnement)
    {
        //ajout
        approvisionnement.setDateAppro(LocalDate.now());
        approvisionnementService.saveApprovisionnement(approvisionnement);
        produitService.updateProduit(approvisionnement.getProduit_id(), approvisionnement.getQte());
        return "redirect:/produits/afficher";
    }

    @GetMapping("/approvisionner/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        System.out.println("id = "+produitService.showOneProduit(id));
        return "Approvisionnement/formApprovisionnement";
    }

    @GetMapping("/Edit/{id}")
    public Approvisionnement showEdit(@PathVariable("id") int id, Model model){
        return approvisionnementService.showOneApprovisionnement(id);
    }

    @PostMapping("/edit")
    public String editApprovisionnement(@ModelAttribute("approvisionnement") Approvisionnement approvisionnement){
        approvisionnementService.saveApprovisionnement((approvisionnement));
        return "redirect:/approvisionnement/afficher";
    }


    @GetMapping ("delete/{id}")
    public String deleteApprovisionnement(@PathVariable("id") int id)
    {
        approvisionnementService.deleteApprovisionnement(id);
        return "redirect:/approvisionnement/afficher";
    }



}
