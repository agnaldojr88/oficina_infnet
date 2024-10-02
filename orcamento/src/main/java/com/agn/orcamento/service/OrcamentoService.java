package com.agn.orcamento.service;

import com.agn.orcamento.model.Carro;
import com.agn.orcamento.model.Orcamento;
import com.agn.orcamento.model.Peca;
import com.agn.orcamento.model.PecaRequest;
import com.agn.orcamento.repository.OrcamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrcamentoService {
    private final OrcamentoRepository orcamentoRepository;

    public List<Orcamento> getAll(){
        return orcamentoRepository.findAll();
    }


    public Orcamento salvar(Orcamento peca){
        return orcamentoRepository.save(peca);
    }


    public Optional<Orcamento> getById(String id){
        return orcamentoRepository.findById(id);
    }


    public BigDecimal calcularValorTotal(PecaRequest pecaRequest){
        return (pecaRequest.getPecas() == null ?
                List.<Peca>of() : pecaRequest.getPecas())
                .stream()
                .map(this::calculaValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculaValor(Peca pecaPedido){
        return pecaPedido.getValor();
    }

}
