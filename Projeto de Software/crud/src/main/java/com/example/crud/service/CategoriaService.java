package com.example.crud.service;

import com.example.crud.model.Categoria;
import com.example.crud.repository.CategoriaRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public boolean existeNomeId(String nome, Integer id) {
        return categoriaRepository.existsByNomeAndIdNot(nome, id);
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> EditarId(Integer id) {
        return categoriaRepository.findById(id);
    }

    public void excluirId(Integer id) {
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir esta categoria pois existem produtos vinculados a ela.");
        }
    }




}
