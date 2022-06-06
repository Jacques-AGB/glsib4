package com.example.tp1.repository;

import com.example.tp1.modele.Produit;
import com.example.tp1.modele.Vente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.SecondaryTable;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VenteRepository extends JpaRepository<Vente, Integer> {

    @Transactional
    @Query(value = "select max(id) from Vente",nativeQuery = true)
    int a();

}
