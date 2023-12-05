package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.ForPgto;
import com.apicomsqlite.aula003.repository.ForPgtoRepository;

import jakarta.transaction.Transactional;

@Service
public class ForPgtoService {

    @Autowired(required = false)
    private ForPgtoRepository forPgtoRepository;

    @Transactional
    public String createforpgto(ForPgto forPgto) {
        try {
            if (!forPgtoRepository.existsByNome(forPgto.getNome())) {
                forPgtoRepository.save(forPgto);
                return "forma de pagamento  cadastrado com sucesso.";
            } else {
                return "forma de pagamento  já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<ForPgto> readforpgto() {
        return forPgtoRepository.findAll();
    }

    @Transactional
    public String updateforpgto(ForPgto forPgto) {
        if (forPgtoRepository.existsById(forPgto.getId())) {
            try {
                Optional<ForPgto> forpgtos = forPgtoRepository.findById(forPgto.getId());
                forpgtos.ifPresent(s -> {
                    ForPgto forpgtoToBeUpdate = forPgtoRepository.findById(s.getId()).orElse(null);
                    if (forpgtoToBeUpdate != null) {
                        forpgtoToBeUpdate.setNome(forPgto.getNome());
                        forPgtoRepository.save(forpgtoToBeUpdate);
                    }
                });
                return "cadastro de forma de pagamento  atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "forma de pagamento  não existe no banco.";
        }
    }

    @Transactional
    public String deleteforpgto(ForPgto produto) {
        if (forPgtoRepository.existsById(produto.getId())) {
            try {
                Optional<ForPgto> forpgtos = forPgtoRepository.findById(produto.getId());
                forpgtos.ifPresent(s -> forPgtoRepository.delete(s));
                return "forma de pagamento deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "forma de pagamento  não existe no banco.";
        }
    }
}
