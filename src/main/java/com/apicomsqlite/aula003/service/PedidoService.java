package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Pedido;
import com.apicomsqlite.aula003.repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    @Autowired(required = false)
    private PedidoRepository pedidoRepository;

    @Transactional
    public String createpedido(Pedido pedido) {
        try {
            if (!pedidoRepository.existsByData(pedido.getData())) {
                pedidoRepository.save(pedido);
                return "pedido cadastrado com sucesso.";
            } else {
                return "pedido já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Pedido> readpedido() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public String updatepedido(Pedido pedido) {
        if (pedidoRepository.existsById(pedido.getId())) {
            try {
                Optional<Pedido> pedidos = pedidoRepository.findById(pedido.getId());
                pedidos.ifPresent(s -> {
                    Pedido pedidoToBeUpdate = pedidoRepository.findById(s.getId()).orElse(null);
                    if (pedidoToBeUpdate != null) {
                        pedidoToBeUpdate.setData(pedido.getData());
                        pedidoToBeUpdate.setStatus(pedido.getStatus());
                        pedidoToBeUpdate.setTotal(pedido.getTotal());
                        pedidoToBeUpdate.setTaxa(pedido.getTaxa());;
                        pedidoRepository.save(pedidoToBeUpdate);
                    }
                });
                return "cadastro de pedido atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "pedido não existe no banco.";
        }
    }

    @Transactional
    public String deletepedido(Pedido pedido) {
        if (pedidoRepository.existsById(pedido.getId())) {
            try {
                Optional<Pedido> pedidos = pedidoRepository.findById(pedido.getId());
                pedidos.ifPresent(s -> pedidoRepository.delete(s));
                return "pedido deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "pedido não existe no banco.";
        }
    }
}
