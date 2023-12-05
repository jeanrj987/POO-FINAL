package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.SaborBorda;

@Repository
public interface SaborBordaRepository extends JpaRepository<SaborBorda, Integer> {

    public boolean existsByNome(String nome);

    public List<SaborBorda> findByNome(String nome);
}
