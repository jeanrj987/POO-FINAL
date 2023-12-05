package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.SaborLanche;

@Repository
public interface SaborLancheRepository extends JpaRepository<SaborLanche, Integer> {

    public boolean existsByNome(String nome);

    public List<SaborLanche> findByNome(String nome);
}
