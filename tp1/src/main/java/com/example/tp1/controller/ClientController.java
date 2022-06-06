package com.example.tp1.controller;

import com.example.tp1.modele.Client;
import com.example.tp1.modele.Produit;
import com.example.tp1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/afficher")
    public String showListClient(Model model){
        model.addAttribute("ListClient", clientService.showClient());
        return "Client/TableClient";
    }

    @GetMapping("/form")
    public String formClient(){
        return "Client/saveClient";
    }

    @PostMapping("/save")
    public String saveClient(Client client){
        clientService.SaveClient(client);
        return "redirect:/vente/VendeurDash";
    }

    @GetMapping("edit/{id}")
    public String FormEdit(@PathVariable("id") int id , Model model){
        model.addAttribute("UnClient", clientService.showOneClient(id));
        return "/Client/formEditClient";
    }

    @PostMapping("/edit")
    public String editClient(@ModelAttribute("client") Client client){
        clientService.SaveClient((client));
        return "redirect:/Client/TableClient";
    }







}
