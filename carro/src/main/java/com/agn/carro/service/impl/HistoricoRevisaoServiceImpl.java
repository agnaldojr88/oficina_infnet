package com.agn.carro.service.impl;

import com.agn.carro.model.Carro;
import com.agn.carro.model.HistoricoRevisao;
import com.agn.carro.repository.HistoricoRevisaoRepository;
import com.agn.carro.service.HistoricoRevisaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HistoricoRevisaoServiceImpl implements HistoricoRevisaoService {
    private final HistoricoRevisaoRepository historicoRevisaoRepository;

    @Override
    public HistoricoRevisao create(HistoricoRevisao historicoRevisao) {
        return historicoRevisaoRepository.save(historicoRevisao);
    }

    @Override
    public Optional<HistoricoRevisao> findById(Long id) {
        return historicoRevisaoRepository.findById(id);
    }

    @Override
    public List<HistoricoRevisao> findAll() {
        return historicoRevisaoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        historicoRevisaoRepository.deleteById(id);
    }

    @Override
    public HistoricoRevisao update(HistoricoRevisao historicoRevisao) {
        return historicoRevisaoRepository.save(historicoRevisao);
    }

    @Override
    public List<HistoricoRevisao> findAllByCarro(Carro carro) {
        return historicoRevisaoRepository.findAllByCarro(carro);
    }
}