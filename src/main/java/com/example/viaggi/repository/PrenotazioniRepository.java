package com.example.viaggi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.viaggi.entity.Prenotazioni;

public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Integer> {
List<Prenotazioni> findByCrawlId(Integer crawlId);

    
    @Query("SELECT p FROM Prenotazioni p WHERE p.crawlId = :crawlId AND MONTH(p.dataEvento) = :mese")
    List<Prenotazioni> findByCrawlIdAndCreatedAtMonth(@Param("crawlId") Integer crawlId, @Param("mese") String mese);
}




