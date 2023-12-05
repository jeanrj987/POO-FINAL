package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.SaborPizza;
import com.apicomsqlite.aula003.service.SaborPizzaService;

@RestController
public class SaborPizzaController {

    @Autowired
    private SaborPizzaService produtoService;

    @RequestMapping(value = "createSaborPizza", method = RequestMethod.POST)
    public String createsaborpizza(@RequestBody SaborPizza saborpizza) {
        return produtoService.createsaborpizza(saborpizza);
    }

    @RequestMapping(value = "readSaborPizza", method = RequestMethod.GET)
    public List<SaborPizza> readsaborpizza() {
        return produtoService.readsaborpizza();
    }

    @RequestMapping(value = "updateSaborPizza", method = RequestMethod.PUT)
    public String updatesaborpizza(@RequestBody SaborPizza saborpizza) {
        return produtoService.updatesaborpizza(saborpizza);
    }

    @RequestMapping(value = "deleteSaborPizza", method = RequestMethod.DELETE)
    public String deletesaborpizza(@RequestBody SaborPizza saborpizza) {
        return produtoService.deletesaborpizza(saborpizza);
    }
}
