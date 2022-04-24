package com.example.tp1.controller;


import com.example.tp1.modele.Produit;
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
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;

    @GetMapping("/afficher")
    public String displayProduct(Model model,@Param("keyword") String keyword)
    {
        List<Produit> produits = produitService.findAllProducts(keyword);
        model.addAttribute("listproduits",produits);
        model.addAttribute("keyword",keyword);
       // return "produits/showProduit";
        return "produits/Table";
    }

    @GetMapping("/form")
    public String renseigner(Model model)
    {
                    model.addAttribute("listCategories",categorieService.showCategories());
        return "produits/saveProduit";
    }

    @GetMapping("/produitsbelowseuil")
    public String displayProductBelow(Model model){
        model.addAttribute("produitBelow",produitService.produitBelow());
        return "produits/produitBelow";
    }

    @PostMapping("/save")
    public String saveProduit(Produit produit)
    {
        produit.setDateCreation(LocalDate.now());
        produit.setQtStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produits/afficher";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnProduit", produitService.showOneProduit(id));
        model.addAttribute("UneCategorie", categorieService.showCategories());
        return "/produits/formEdit";
    }

    @PostMapping("/edit")
    public String editProduit(@ModelAttribute("produit") Produit produit){
        produitService.saveProduit((produit));
        return "redirect:/produits/afficher";
    }


    @GetMapping ("delete/{id}")
    public String deleteProduit(@PathVariable("id") int id)
    {
        produitService.deleteProduit(id);
        return "redirect:/produits/afficher";
    }




}

