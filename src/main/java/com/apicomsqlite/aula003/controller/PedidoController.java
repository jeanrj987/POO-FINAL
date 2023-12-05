package com.apicomsqlite.aula003.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.apicomsqlite.aula003.enity.Pedido;
import com.apicomsqlite.aula003.service.PedidoService;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(value = "createPedido", method = RequestMethod.POST)
    public String createpedido(@RequestBody Pedido pedido) {
        return pedidoService.createpedido(pedido);
    }

    @RequestMapping(value = "readPedido", method = RequestMethod.GET)
    public List<Pedido> readpedido() {
        return pedidoService.readpedido();
    }

    @RequestMapping(value = "updatePedido", method = RequestMethod.PUT)
    public String updatepedido(@RequestBody Pedido pedido) {
        return pedidoService.updatepedido(pedido);
    }

    @RequestMapping(value = "deletePedido", method = RequestMethod.DELETE)
    public String deletepedido(@RequestBody Pedido pedido) {
        return pedidoService.deletepedido(pedido);
    }
}
