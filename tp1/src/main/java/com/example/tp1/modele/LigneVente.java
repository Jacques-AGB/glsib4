package com.example.tp1.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class LigneVente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qte;

    @ManyToOne
    @JoinColumn(name = "produitId", insertable = false, updatable = false)
    private Produit produit;
    private int produitId;

    @ManyToOne
    @JoinColumn(name = "venteId", updatable = false, insertable = false)
    private Vente vente;
    private int venteId;

}
