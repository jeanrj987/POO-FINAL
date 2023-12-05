package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.SaborPizza;
import com.apicomsqlite.aula003.repository.SaborPizzaRepository;
import jakarta.transaction.Transactional;

@Service
public class SaborPizzaService {

    @Autowired(required = false)
    private SaborPizzaRepository saborpizzaRepository;

    @Transactional
    public String createsaborpizza(SaborPizza saborpizza) {
        try {
            if (!saborpizzaRepository.existsByNome(saborpizza.getNome())) {
                saborpizzaRepository.save(saborpizza);
                return "sabor da pizza cadastrado com sucesso.";
            } else {
                return "sabor da pizza já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<SaborPizza> readsaborpizza() {
        return saborpizzaRepository.findAll();
    }

    @Transactional
    public String updatesaborpizza(SaborPizza saborpizza) {
        if (saborpizzaRepository.existsById(saborpizza.getId())) {
            try {
                Optional<SaborPizza> saborPizzas = saborpizzaRepository.findById(saborpizza.getId());
                saborPizzas.ifPresent(s -> {
                    SaborPizza saborpizzaToBeUpdate = saborpizzaRepository.findById(s.getId()).orElse(null);
                    if (saborpizzaToBeUpdate != null) {
                        saborpizzaToBeUpdate.setNome(saborpizza.getNome());
                        saborpizzaRepository.save(saborpizzaToBeUpdate);
                    }
                });
                return "cadastro de sabor da pizza atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "sabor da pizza não existe no banco.";
        }
    }

    @Transactional
    public String deletesaborpizza(SaborPizza saborpizza) {
        if (saborpizzaRepository.existsById(saborpizza.getId())) {
            try {
                Optional<SaborPizza> saborPizzas = saborpizzaRepository.findById(saborpizza.getId());
                saborPizzas.ifPresent(s -> saborpizzaRepository.delete(s));
                return "sabor da pizza deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "saborpizza não existe no banco.";
        }
    }
}
