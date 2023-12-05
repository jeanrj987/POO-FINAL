package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.SaborBorda;
import com.apicomsqlite.aula003.repository.SaborBordaRepository;
import jakarta.transaction.Transactional;

@Service
public class SaborBordaService {

    @Autowired(required = false)
    private SaborBordaRepository saborbordaRepository;

    @Transactional
    public String createsaborborda(SaborBorda saborborda) {
        try {
            if (!saborbordaRepository.existsByNome(saborborda.getNome())) {
                saborbordaRepository.save(saborborda);
                return "sabor da borda cadastrado com sucesso.";
            } else {
                return "sabor da borda já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<SaborBorda> readsaborborda() {
        return saborbordaRepository.findAll();
    }

    @Transactional
    public String updatesaborborda(SaborBorda saborborda) {
        if (saborbordaRepository.existsById(saborborda.getId())) {
            try {
                Optional<SaborBorda> saborBordas = saborbordaRepository.findById(saborborda.getId());
                saborBordas.ifPresent(s -> {
                    SaborBorda saborbordaToBeUpdate = saborbordaRepository.findById(s.getId()).orElse(null);
                    if (saborbordaToBeUpdate != null) {
                        saborbordaToBeUpdate.setNome(saborborda.getNome());
                        saborbordaRepository.save(saborbordaToBeUpdate);
                    }
                });
                return "cadastro de sabor da borda atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "sabor da borda não existe no banco.";
        }
    }

    @Transactional
    public String deletesaborborda(SaborBorda saborborda) {
        if (saborbordaRepository.existsById(saborborda.getId())) {
            try {
                Optional<SaborBorda> saborBordas = saborbordaRepository.findById(saborborda.getId());
                saborBordas.ifPresent(s -> saborbordaRepository.delete(s));
                return "sabor da borda deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "saborborda não existe no banco.";
        }
    }
}
