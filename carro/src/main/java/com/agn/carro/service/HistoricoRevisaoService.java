package com.agn.carro.service;

import com.agn.carro.model.Carro;
import com.agn.carro.model.HistoricoRevisao;

import java.util.List;
import java.util.Optional;

public interface HistoricoRevisaoService {
    HistoricoRevisao create(HistoricoRevisao historicoRevisao);
    Optional<HistoricoRevisao> findById(Long id);
    List<HistoricoRevisao> findAll();
    void deleteById(Long id);
    HistoricoRevisao update(HistoricoRevisao historicoRevisao);
    List<HistoricoRevisao> findAllByCarro(Carro carro);

}
