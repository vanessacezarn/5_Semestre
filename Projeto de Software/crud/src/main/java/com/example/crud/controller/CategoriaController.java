package com.example.crud.controller;

import com.example.crud.model.Categoria;

import com.example.crud.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping("/formularioCategoria")
    public String exibirFormularioCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "formularioCategoria";
    }

    /*esta testado se o dado é valido antes de tentar salva no banco de dados */
    @PostMapping("/salvarCategoria")
    public String salvarCategoria(@Validated @ModelAttribute Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "formularioCategoria";
        }
        if (categoriaService.existeNomeId(categoria.getNome(), categoria.getId())) {
            result.rejectValue("nome",null,"Já existe uma categoria com esse nome.");
            return "formularioCategoria";
        }
        categoriaService.salvar(categoria);
        return "redirect:/categoria/listarCategoria";
    }

    @GetMapping("/listarCategoria")
    public String listarCategoria(Model model) {
        List<Categoria> categorias = categoriaService.listarTodas();
        model.addAttribute("categorias", categorias);
        return "listaCategoria";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCategoria(@PathVariable Integer id, Model model) {
        /*PathVariable = variavel de caminho, ela esta vindo junto com url*/
        try {
            categoriaService.excluirId(id);
        } catch (RuntimeException e) {
            model.addAttribute("erro", e.getMessage());
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "listaCategoria";
        }

        return "redirect:/categoria/listarCategoria";
    }

    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Integer id, Model model) {
        Categoria categoria = categoriaService.EditarId(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        model.addAttribute("categoria", categoria);
        return "formularioCategoria";
    }
}
