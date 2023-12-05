package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.SaborBorda;
import com.apicomsqlite.aula003.service.SaborBordaService;

@RestController
public class SaborBordaController {

    @Autowired
    private SaborBordaService sabobordaService;

    @RequestMapping(value = "createSaborBorda", method = RequestMethod.POST)
    public String createsaborborda(@RequestBody SaborBorda saborborda) {
        return sabobordaService.createsaborborda(saborborda);
    }

    @RequestMapping(value = "readSaborBorda", method = RequestMethod.GET)
    public List<SaborBorda> readsaborborda() {
        return sabobordaService.readsaborborda();
    }

    @RequestMapping(value = "updateSaborBorda", method = RequestMethod.PUT)
    public String updatesaborborda(@RequestBody SaborBorda saborborda) {
        return sabobordaService.updatesaborborda(saborborda);
    }

    @RequestMapping(value = "deleteSaborBorda", method = RequestMethod.DELETE)
    public String deletesaborborda(@RequestBody SaborBorda saborborda) {
        return sabobordaService.deletesaborborda(saborborda);
    }
}
