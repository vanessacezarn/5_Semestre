package com.example.crud.controller;

import com.example.crud.model.Categoria;
import com.example.crud.model.Produto;
import com.example.crud.repository.ProdutoRepository;
import com.example.crud.service.CategoriaService;
import com.example.crud.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;

    public ProdutoController(ProdutoService produtoService, CategoriaService categoriaService) {
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
    public String salvarProduto(@Validated @ModelAttribute Produto produto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "formulario";
        }
        if(produtoService.existeNomeId(produto.getId(),produto.getNome())){
            result.rejectValue("nome",null,"Já existe um produto cadastrado com esse nome.");
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "formulario";
        }
        if(produto.getValor() <= 0){
            result.rejectValue("valor", null, "O valor deve ser maior que 0");
            model.addAttribute("categorias", categoriaService.listarTodas());
            return "formulario";
        }
        produtoService.salvar(produto);
        return "redirect:/produto/listar";
    }

    @GetMapping("/listar")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoService.listarTodos();
        model.addAttribute("produtos", produtos);
        return "lista";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Integer id, Model model) {
        /*PathVariable = variavel de caminho, ela esta vindo junto com url*/
       try{
           produtoService.excluirId(id);
       }catch(RuntimeException e){
           model.addAttribute("erro", e.getMessage());
           model.addAttribute("produtos", produtoService.listarTodos());
           return "listar";
       }
        return "redirect:/produto/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Integer id, Model model) {
        Produto produto = produtoService.EditarId(id).orElseThrow(() -> new RuntimeException("Produto não encontrada"));
        model.addAttribute("produto", produto);
        model.addAttribute("categorias", categoriaService.listarTodas());

        return "formulario";
    }


}
