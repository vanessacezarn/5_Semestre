package com.example.crud.repository;

import com.example.crud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    boolean existsByNomeAndIdNot(String nome,Integer id);
}
