package com.example.tp1.repository;

import com.example.tp1.modele.Approvisionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ApprovisionnementRepository extends JpaRepository<Approvisionnement, Integer> {
}
