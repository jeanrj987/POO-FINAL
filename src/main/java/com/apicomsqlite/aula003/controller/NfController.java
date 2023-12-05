// NfController.java
package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.Nf;
import com.apicomsqlite.aula003.service.NfService;

@RestController
public class NfController {

    @Autowired
    private NfService nfService;

    @RequestMapping(value = "createNf", method = RequestMethod.POST)
    public String createNf(@RequestBody Nf nf) {
        return nfService.createNf(nf);
    }

    @RequestMapping(value = "readNf", method = RequestMethod.GET)
    public List<Nf> readNf() {
        return nfService.readNf();
    }

    @RequestMapping(value = "updateNf", method = RequestMethod.PUT)
    public String updateNf(@RequestBody Nf nf) {
        return nfService.updateNf(nf);
    }

    @RequestMapping(value = "deleteNf", method = RequestMethod.DELETE)
    public String deleteNf(@RequestBody Nf nf) {
        return nfService.deleteNf(nf);
    }
}
