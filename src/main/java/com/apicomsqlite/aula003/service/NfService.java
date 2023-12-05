// NfService.java
package com.apicomsqlite.aula003.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apicomsqlite.aula003.enity.Nf;
import com.apicomsqlite.aula003.repository.NfRepository;

import jakarta.transaction.Transactional;

@Service
public class NfService {

    @Autowired
    private NfRepository nfRepository;

    @Transactional
    public String createNf(Nf nf) {
        try {
            if (!nfRepository.existsByNumNota(nf.getNumNota())) {
                nfRepository.save(nf);
                return "Nf cadastrado com sucesso.";
            } else {
                return "Nf já existe no database.";
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Nf> readNf() {
        return nfRepository.findAll();
    }

    @Transactional
    public String updateNf(Nf nf) {
        if (nfRepository.existsById(nf.getId())) {
            try {
                Optional<Nf> nfs = nfRepository.findById(nf.getId());
                nfs.ifPresent(s -> {
                    Nf nfToBeUpdate = nfRepository.findById(s.getId()).orElse(null);
                    if (nfToBeUpdate != null) {
                        nfToBeUpdate.setNumNota(nf.getNumNota());
                        // Atualize os outros campos se necessário
                        nfRepository.save(nfToBeUpdate);
                    }
                });
                return "Cadastro de Nf atualizado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Nf não existe no banco.";
        }
    }

    @Transactional
    public String deleteNf(Nf nf) {
        if (nfRepository.existsById(nf.getId())) {
            try {
                Optional<Nf> nfs = nfRepository.findById(nf.getId());
                nfs.ifPresent(s -> nfRepository.delete(s));
                return "Nf deletado.";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Nf não existe no banco.";
        }
    }
}
