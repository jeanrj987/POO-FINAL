package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.ItensPedido;
import com.apicomsqlite.aula003.service.ItensPedidoService;

@RestController
public class ItensPedidoController {

    @Autowired
    private ItensPedidoService itensPedidoService;

    @RequestMapping(value = "createItensPedido", method = RequestMethod.POST)
    public String createitenspedido(@RequestBody ItensPedido itensPedido) {
        return itensPedidoService.createitenspedido(itensPedido);
    }

    @RequestMapping(value = "readItensPedido", method = RequestMethod.GET)
    public List<ItensPedido> readitenspedido() {
        return itensPedidoService.readclientes();
    }

    @RequestMapping(value = "updateItensPedido", method = RequestMethod.PUT)
    public String updateitenspedido(@RequestBody ItensPedido itensPedido) {
        return itensPedidoService.updateitenspedido(itensPedido);
    }

    @RequestMapping(value = "deleteItensPedido", method = RequestMethod.DELETE)
    public String deleteitenspedido(@RequestBody ItensPedido itensPedido) {
        return itensPedidoService.deleteitenspedido(itensPedido);
    }
}
