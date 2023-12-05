package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Produto;
import com.apicomsqlite.aula003.repository.ProdutoRespository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired(required = false)
    private ProdutoRespository produtoRespository;

    @Transactional
    public String createproduto(Produto produto) {
        try {
            if (!produtoRespository.existsByNome(produto.getNome())) {
                produtoRespository.save(produto);
                return "produto cadastrado com sucesso.";
            } else {
                return "produto já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Produto> readproduto() {
        return produtoRespository.findAll();
    }

    @Transactional
    public String updateproduto(Produto produto) {
        if (produtoRespository.existsById(produto.getId())) {
            try {
                Optional<Produto> produtos = produtoRespository.findById(produto.getId());
                produtos.ifPresent(s -> {
                    Produto produtoToBeUpdate = produtoRespository.findById(s.getId()).orElse(null);
                    if (produtoToBeUpdate != null) {
                        produtoToBeUpdate.setNome(produto.getNome());
                        produtoToBeUpdate.setPreco(produto.getPreco());
                        produtoRespository.save(produtoToBeUpdate);
                    }
                });
                return "cadastro de produto atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "produto não existe no banco.";
        }
    }

    @Transactional
    public String deleteproduto(Produto produto) {
        if (produtoRespository.existsById(produto.getId())) {
            try {
                Optional<Produto> produtos = produtoRespository.findById(produto.getId());
                produtos.ifPresent(s -> produtoRespository.delete(s));
                return "produto deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "produto não existe no banco.";
        }
    }
}
