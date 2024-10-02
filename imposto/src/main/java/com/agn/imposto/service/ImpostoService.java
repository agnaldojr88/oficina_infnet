package com.agn.imposto.service;

import com.agn.imposto.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpostoService {

    private final PecaService pecaService;

    @Value("${taxas.usa}")
    private BigDecimal taxaUsa;

    @Value("${taxas.europa}")
    private BigDecimal taxaEuropa;

    @Value("${taxas.brasil}")
    private BigDecimal taxaBrasil;


    public BigDecimal calcularImpostoTotal(PecaPayload pecaPayload){
        return (pecaPayload.pecas() == null ?
                List.<Peca>of() : pecaPayload.pecas())
                .stream()
                .map(this::calcularImposto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }



    private BigDecimal calcularImposto(Peca pecaPedido){

        Peca peca = pecaService.getById(pecaPedido.getId());

        BigDecimal taxa = getTaxas(Pais.USA);

        return peca.getValor().multiply(taxa)
                .multiply(new BigDecimal(1));

    }


    private BigDecimal getTaxas(Pais pais){
        return switch (pais){
            case USA -> taxaUsa;
            case EUROPA -> taxaEuropa;
            case BRASIL -> taxaBrasil;
        };
    }

}
