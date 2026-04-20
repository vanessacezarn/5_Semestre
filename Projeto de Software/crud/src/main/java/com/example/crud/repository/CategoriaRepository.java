package com.example.crud.repository;

import com.example.crud.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    boolean existsByNomeAndIdNot(String nome, Integer id);
}
