package com.agn.orcamento.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "orcamentos") // Define a coleção no MongoDB
public class Orcamento {

    @Id
    private String id;
    private String descricao;
    private ArrayList<Peca> pecas;
    private Carro carro;

    private BigDecimal preco;
    private BigDecimal valorImposto;



}
