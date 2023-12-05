package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {

    public boolean existsByNome(String nome);

    public List<Clientes> findByNome(String nome);
}
