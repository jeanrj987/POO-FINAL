package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.Produto;

@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Integer> {

    public boolean existsByNome(String nome);

    public List<Produto> findByNome(String nome);
}
