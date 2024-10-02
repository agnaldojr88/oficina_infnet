package com.agn.orcamento.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carro {
    private Long id;
    private String nome;
    private String fabricante;
    private float quilometragem;
    private String placa;
}
