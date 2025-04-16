package com.example.viaggi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.viaggi.entity.Crawl;

public interface CrawlRepository extends JpaRepository<Crawl, Integer> {
    
}
