package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.ForPgto;
import com.apicomsqlite.aula003.service.ForPgtoService;

@RestController
public class ForPgtoController {

    @Autowired
    private ForPgtoService ForPgtoService;

    @RequestMapping(value = "createForPgto", method = RequestMethod.POST)
    public String createforpgto(@RequestBody ForPgto forPgto) {
        return ForPgtoService.createforpgto(forPgto);
    }

    @RequestMapping(value = "readForPgto", method = RequestMethod.GET)
    public List<ForPgto> readforpgto() {
        return ForPgtoService.readforpgto();
    }

    @RequestMapping(value = "updateForPgto", method = RequestMethod.PUT)
    public String updateforpgto(@RequestBody ForPgto forPgto) {
        return ForPgtoService.updateforpgto(forPgto);
    }

    @RequestMapping(value = "deleteForPgto", method = RequestMethod.DELETE)
    public String deleteforpgto (@RequestBody ForPgto forPgto) {
        return ForPgtoService.deleteforpgto(forPgto);
    }
}
