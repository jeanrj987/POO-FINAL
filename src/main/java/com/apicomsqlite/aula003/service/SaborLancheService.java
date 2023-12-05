package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.SaborLanche;
import com.apicomsqlite.aula003.repository.SaborLancheRepository;
import jakarta.transaction.Transactional;

@Service
public class SaborLancheService {

    @Autowired(required = false)
    private SaborLancheRepository saborlancheRepository;

    @Transactional
    public String createsaborlanche(SaborLanche saborlanche) {
        try {
            if (!saborlancheRepository.existsByNome(saborlanche.getNome())) {
                saborlancheRepository.save(saborlanche);
                return "sabor do lanche cadastrado com sucesso.";
            } else {
                return "sabor do lanche já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<SaborLanche> readsaborlanche() {
        return saborlancheRepository.findAll();
    }

    @Transactional
    public String updatesaborlanche(SaborLanche saborlanche) {
        if (saborlancheRepository.existsById(saborlanche.getId())) {
            try {
                Optional<SaborLanche> saborLanches = saborlancheRepository.findById(saborlanche.getId());
                saborLanches.ifPresent(s -> {
                    SaborLanche saborlancheToBeUpdate = saborlancheRepository.findById(s.getId()).orElse(null);
                    if (saborlancheToBeUpdate != null) {
                        saborlancheToBeUpdate.setNome(saborlanche.getNome());
                        saborlancheRepository.save(saborlancheToBeUpdate);
                    }
                });
                return "cadastro de sabor do lanche atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "sabor do lanche não existe no banco.";
        }
    }

    @Transactional
    public String deletesaborlanche(SaborLanche saborlanche) {
        if (saborlancheRepository.existsById(saborlanche.getId())) {
            try {
                Optional<SaborLanche> saborBordas = saborlancheRepository.findById(saborlanche.getId());
                saborBordas.ifPresent(s -> saborlancheRepository.delete(s));
                return "sabor do lanche deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "sabor do lanche não existe no banco.";
        }
    }
}
