package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.SaborPizza;

@Repository
public interface SaborPizzaRepository extends JpaRepository<SaborPizza, Integer> {

    public boolean existsByNome(String nome);

    public List<SaborPizza> findByNome(String nome);
}
