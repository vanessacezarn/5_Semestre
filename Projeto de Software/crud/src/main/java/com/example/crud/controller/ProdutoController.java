package com.example.crud.controller;

import com.example.crud.model.Categoria;
import com.example.crud.model.Produto;
import com.example.crud.repository.ProdutoRepository;
import com.example.crud.service.CategoriaService;
import com.example.crud.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    public ProdutoController(ProdutoRepository produtoRepository, ProdutoService produtoService, CategoriaService categoriaService) {
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/formulario")
    public String exibirFormulario(Model model) {
        List<Categoria> categorias = categoriaService.listarTodas();
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", categorias);
        return "formulario";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "lista";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Integer id) {
        /*PathVariable = variavel de caminho, ela esta vindo junto com url*/
        produtoRepository.deleteById(id);
        return "redirect:/produto/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Integer id, Model model) {
        Optional<Produto> produto = produtoRepository.findById(id);
        model.addAttribute("produto", produto);
        return "formulario";
    }


}
