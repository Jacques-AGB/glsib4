package com.example.tp1.controller;

import com.example.tp1.modele.Client;
import com.example.tp1.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/afficher")
    public String showListClient(Model model){
        model.addAttribute("ListClient", clientService.showClient());
        return "Client/showClient";
    }

    @GetMapping("/formClient")
    public String formClient(){
        return "Client/formClient";
    }

    @PostMapping()
    public String saveClient(Client client){
        clientService.SaveClient(client);
        return "redirect:/Client/afficher";
    }


}
