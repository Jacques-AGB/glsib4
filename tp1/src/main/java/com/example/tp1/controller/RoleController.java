package com.example.tp1.controller;

import com.example.tp1.modele.Role;
import com.example.tp1.modele.User;
import com.example.tp1.service.CategorieService;
import com.example.tp1.service.MyUserDetailsService;
import com.example.tp1.service.ProduitService;
import com.example.tp1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieService categorieService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/afficher")
    public String displayRole(Model model)
    {
        model.addAttribute("listRoles",roleService.ShowAllRole());
        return "User/ShowUser";
    }

    @GetMapping("/form")
    public String renseigner(Model model)
    {
        return "Role/saveRole";
    }


    @PostMapping("/save")
    public String saveRole(Role role)
    {
        roleService.saveRole(role);
        return "redirect:/admin";
    }

}
