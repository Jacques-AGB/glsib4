package com.example.tp1.repository;

import com.example.tp1.modele.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.SecondaryTable;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {
}
