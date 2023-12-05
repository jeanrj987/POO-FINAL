package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.ForPgto;

@Repository
public interface ForPgtoRepository extends JpaRepository<ForPgto, Integer> {

    public boolean existsByNome(String nome);

    public List<ForPgto> findByNome(String nome);
}
