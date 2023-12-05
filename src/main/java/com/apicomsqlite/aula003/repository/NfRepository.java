// NfRepository.java
package com.apicomsqlite.aula003.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apicomsqlite.aula003.enity.Nf;

@Repository
public interface NfRepository extends JpaRepository<Nf, Integer> {

    boolean existsByNumNota(int numNota);

    List<Nf> findByNumNota(int numNota);
}
