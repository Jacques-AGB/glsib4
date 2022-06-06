package com.example.tp1.repository;

import com.example.tp1.modele.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface LigneVenteRepository extends JpaRepository<LigneVente, Integer> {
    @Transactional
    @Query(value = "select sum(l.quantite * p.prix) from produits p inner join Lignevente l on l.produitId = p.id where venteIdd= :venteId ", nativeQuery = true)
    String b(@Param("venteId") int id);

    @Transactional
    @Query(value = "select * from ligne_vente where vente_id =:id",nativeQuery = true)
    List<LigneVente> lect(@Param("id") int id);
}
