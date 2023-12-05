package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.ItensPedido;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Integer> {

    public boolean existsByNome(String nome);

    public List<ItensPedido> findByNome(String nome);
}
