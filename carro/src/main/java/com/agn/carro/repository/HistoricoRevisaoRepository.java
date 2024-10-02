package com.agn.carro.repository;

import com.agn.carro.model.Carro;
import com.agn.carro.model.HistoricoRevisao;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoricoRevisaoRepository extends JpaRepository<HistoricoRevisao, Long> {

    @Query("SELECT r FROM HistoricoRevisao r WHERE r.carro= :p_carro")
    List<HistoricoRevisao> findAllByCarro(@Param("p_carro")Carro p_carro);

}
