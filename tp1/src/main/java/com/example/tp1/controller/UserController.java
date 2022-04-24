package com.example.tp1.controller;

import com.example.tp1.modele.Produit;
import com.example.tp1.modele.User;
import com.example.tp1.service.CategorieService;
import com.example.tp1.service.MyUserDetailsService;
import com.example.tp1.service.ProduitService;
import com.example.tp1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/afficher")
    public String displayUser(Model model)
    {
        model.addAttribute("User",myUserDetailsService.showUser());
        return "User/ShowUser";
    }

    @GetMapping("/form")
    public String renseigner(Model model)
    {
        model.addAttribute("listRoles",roleService.ShowAllRole());
        return "User/saveUser";
    }


    @PostMapping("/save")
    public String saveUser(User user)
    {
        myUserDetailsService.saveUser(user);
        return "redirect:/user/afficher";
    }


}
