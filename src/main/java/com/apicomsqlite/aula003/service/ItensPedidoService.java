package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.ItensPedido;
import com.apicomsqlite.aula003.repository.ItensPedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class ItensPedidoService {

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Transactional
    public String createitenspedido(ItensPedido itenspedido) {
        try {
            if (!itensPedidoRepository.existsByNome(itenspedido.getNome())) {
                itensPedidoRepository.save(itenspedido);
                return "itenspedido cadastrado com sucesso.";
            } else {
                return "itenspedido já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ItensPedido> readclientes() {
        return itensPedidoRepository.findAll();
    }

    @Transactional
    public String updateitenspedido(ItensPedido itenspedido) {
        if (itensPedidoRepository.existsById(itenspedido.getId())) {
            try {
                Optional<ItensPedido> itensPedidoOptional = itensPedidoRepository.findById(itenspedido.getId());
                itensPedidoOptional.ifPresent(s -> {
                    ItensPedido itensPedidoToBeUpdate = s;
                    itensPedidoToBeUpdate.setNome(itenspedido.getNome());
                    itensPedidoToBeUpdate.setQuantidade(itenspedido.getQuantidade());
                    itensPedidoRepository.save(itensPedidoToBeUpdate);
                });
                return "cadastro de itenspedido atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "itenspedido não existe no banco.";
        }
    }

    @Transactional
    public String deleteitenspedido(ItensPedido itenspedido) {
        if (itensPedidoRepository.existsById(itenspedido.getId())) {
            try {
                itensPedidoRepository.deleteById(itenspedido.getId());
                return "itenspedido deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "itenspedido não existe no banco.";
        }
    }
}
