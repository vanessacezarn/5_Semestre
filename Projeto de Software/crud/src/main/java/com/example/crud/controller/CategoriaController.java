package com.example.crud.controller;

import com.example.crud.model.Categoria;

import com.example.crud.model.Produto;
import com.example.crud.repository.CategoriaRepository;
import com.example.crud.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaRepository categoriaRepository, CategoriaService categoriaService) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaService = categoriaService;
    }
    @GetMapping("/formularioCategoria")
    public String exibirFormularioCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formularioCategoria";
    }

    @PostMapping("/salvarCategoria")
    public String salvarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.salvar(categoria);
        return "redirect:/categoria/listarCategoria";
    }

    @GetMapping("/listarCategoria")
    public String listarCategoria(Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categoria", categorias);
        return "listaCategoria";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCategoria(@PathVariable Integer id) {
        /*PathVariable = variavel de caminho, ela esta vindo junto com url*/
        categoriaRepository.deleteById(id);
        return "redirect:/categoria/listarCategoria";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Integer id, Model model) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        model.addAttribute("categoria", categoria);
        return "formularioCategoria";
    }
}
