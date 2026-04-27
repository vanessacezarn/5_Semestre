package com.example.prova.repository;

import com.example.prova.model.Led;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LedRepository extends JpaRepository<Led,Integer> {
}
