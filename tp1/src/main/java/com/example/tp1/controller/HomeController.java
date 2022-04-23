package com.example.tp1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/logout")
    public  String logoutPage(){
        return "logout";
    }

    @GetMapping("/home")
    public String afficherHome(Model model){
        model.addAttribute("Total" ,produitService.countQte());
        model.addAttribute("produitBelow",produitService.produitBelow());
        return "Index";
    }
}
