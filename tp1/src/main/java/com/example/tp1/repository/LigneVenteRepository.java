package com.example.tp1.repository;

import com.example.tp1.modele.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {
}
