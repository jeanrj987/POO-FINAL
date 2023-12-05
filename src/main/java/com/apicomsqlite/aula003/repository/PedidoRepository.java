package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    public boolean existsByData(String data);

    public List<Pedido> findByData(String data);
}
