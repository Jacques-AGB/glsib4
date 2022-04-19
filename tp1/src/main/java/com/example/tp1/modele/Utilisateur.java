package com.example.tp1.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String password;
    private String email;
    private String adresse;
    private String numTelephone;
    @ManyToOne
    @JoinColumn(name = "roleId", insertable = false, updatable = false)
    private Role role;
    private int roleId;

}
