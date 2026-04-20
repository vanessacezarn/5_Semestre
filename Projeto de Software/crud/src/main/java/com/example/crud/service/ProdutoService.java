package com.example.crud.service;

import com.example.crud.model.Produto;
import com.example.crud.repository.ProdutoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
     private final ProdutoRepository produtoRepository;

     public ProdutoService(ProdutoRepository produtoRepository) {
         this.produtoRepository = produtoRepository;
     }

     public void salvar(Produto produto) {

          if(produto.getCategoria() == null){
              throw new RuntimeException("A categoria do produto é obrigatória");
          }
          produtoRepository.save(produto);
     }
    public boolean existeNomeId(Integer id,String nome) {
        return produtoRepository.existsByNomeAndIdNot(nome,id);
    }
    public List<Produto> listarTodos(){
        return produtoRepository.findAll();
    }
    public Optional<Produto> EditarId(Integer id){
         return produtoRepository.findById(id);
    }

    /*nesse momento não seria necessario o try catch pois produto não está vinculado a nada
    * mas caso o sistema escalone para vendas, o historico de vendas não pode ser afetado
    * pela exclusão de um produto que não esta mais disponivel*/

    public void excluirId(Integer id) {
        try {
            produtoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir esta produto pois existem produtos vinculados a algo");
        }
    }




}
