package com.agn.carro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data@AllArgsConstructor@NoArgsConstructor@Builder
@Entity
public class HistoricoRevisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String data;

    @ManyToOne
    //@JoinColumn(name = "idCarro")
    private Carro carro;




}
