package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.Clientes;
import com.apicomsqlite.aula003.service.ClientesService;

@RestController
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @RequestMapping(value = "createCliente", method = RequestMethod.POST)
    public String createclientes(@RequestBody Clientes cliente) {
        return clientesService.createclientes(cliente);
    }

    @RequestMapping(value = "readCliente", method = RequestMethod.GET)
    public List<Clientes> readclientes() {
        return clientesService.readclientes();
    }

    @RequestMapping(value = "updateCliente", method = RequestMethod.PUT)
    public String updateclientes(@RequestBody Clientes cliente) {
        return clientesService.updateclientes(cliente);
    }

    @RequestMapping(value = "deleteCliente", method = RequestMethod.DELETE)
    public String deleteclientes(@RequestBody Clientes cliente) {
        return clientesService.deleteclientes(cliente);
    }
}
