package com.agn.imposto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Peca {

    private Long id;
    private String nome;
    private BigDecimal valor;
    private BigDecimal imposto;
    private String fabricante;
    private long idFabricante;


}