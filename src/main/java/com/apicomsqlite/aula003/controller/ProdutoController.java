package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.Produto;
import com.apicomsqlite.aula003.service.ProdutoService;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping(value = "createProduto", method = RequestMethod.POST)
    public String createproduto(@RequestBody Produto produto) {
        return produtoService.createproduto(produto);
    }

    @RequestMapping(value = "readProduto", method = RequestMethod.GET)
    public List<Produto> readproduto() {
        return produtoService.readproduto();
    }

    @RequestMapping(value = "updateProduto", method = RequestMethod.PUT)
    public String updateproduto(@RequestBody Produto produto) {
        return produtoService.updateproduto(produto);
    }

    @RequestMapping(value = "deleteProduto", method = RequestMethod.DELETE)
    public String deleteproduto(@RequestBody Produto produto) {
        return produtoService.deleteproduto(produto);
    }
}
