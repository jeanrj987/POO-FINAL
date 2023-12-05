package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.SaborLanche;
import com.apicomsqlite.aula003.service.SaborLancheService;

@RestController
public class SaborLancheController {

    @Autowired
    private SaborLancheService saborlancheService;

    @RequestMapping(value = "createSaborLanche", method = RequestMethod.POST)
    public String createsaborlanche(@RequestBody SaborLanche saborlanche) {
        return saborlancheService.createsaborlanche(saborlanche);
    }

    @RequestMapping(value = "readSaborLanche", method = RequestMethod.GET)
    public List<SaborLanche> readsaborlanche() {
        return saborlancheService.readsaborlanche();
    }

    @RequestMapping(value = "updateSaborLanche", method = RequestMethod.PUT)
    public String updatesaborlanche(@RequestBody SaborLanche saborlanche) {
        return saborlancheService.updatesaborlanche(saborlanche);
    }

    @RequestMapping(value = "deleteSaborLanche", method = RequestMethod.DELETE)
    public String deletesaborlanche(@RequestBody SaborLanche saborlanche) {
        return saborlancheService.deletesaborlanche(saborlanche);
    }
}
