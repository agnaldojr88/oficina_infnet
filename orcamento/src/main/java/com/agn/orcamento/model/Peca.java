package com.agn.orcamento.model;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collation = "pecas")
public class Peca {

    @Id
    private Long id;
    private String nome;
    private BigDecimal valor;
    private BigDecimal imposto;
    private String fabricante;
    private int disponibilidade;
    private int quantEmEstoque;


}