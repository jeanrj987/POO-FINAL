package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Clientes;
import com.apicomsqlite.aula003.repository.ClientesRepository;
import jakarta.transaction.Transactional;

@Service
public class ClientesService {

    @Autowired(required = false)
    private ClientesRepository clientesRepository;

    @Transactional
    public String createclientes(Clientes cliente) {
        try {
            if (!clientesRepository.existsByNome(cliente.getNome())) {
                clientesRepository.save(cliente);
                return "cliente cadastrado com sucesso.";
            } else {
                return "cliente já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Clientes> readclientes() {
        return clientesRepository.findAll();
    }

    @Transactional
    public String updateclientes(Clientes cliente) {
        if (clientesRepository.existsById(cliente.getId())) {
            try {
                Optional<Clientes> clientes = clientesRepository.findById(cliente.getId());
                clientes.ifPresent(s -> {
                    Clientes clienteToBeUpdate = clientesRepository.findById(s.getId()).orElse(null);
                    if (clienteToBeUpdate != null) {
                        clienteToBeUpdate.setNome(cliente.getNome());
                        clienteToBeUpdate.setTelefone(cliente.getTelefone());
                        clientesRepository.save(clienteToBeUpdate);
                    }
                });
                return "cadastro de cliente atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "cliente não existe no banco.";
        }
    }

    @Transactional
    public String deleteclientes(Clientes cliente) {
        if (clientesRepository.existsById(cliente.getId())) {
            try {
                Optional<Clientes> clientes = clientesRepository.findById(cliente.getId());
                clientes.ifPresent(s -> clientesRepository.delete(s));
                return "cliente deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "cliente não existe no banco.";
        }
    }
}
