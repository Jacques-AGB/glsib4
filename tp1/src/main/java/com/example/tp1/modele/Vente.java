package com.example.tp1.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private int qte;
    private LocalDate dateVente;

    @ManyToOne
    @JoinColumn(name = "user_id" , insertable = false, updatable = false)
    private User user;
    private int user_id;

    @ManyToOne
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;
    private int clientId;

}
