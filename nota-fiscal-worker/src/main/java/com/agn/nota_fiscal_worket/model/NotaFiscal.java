package com.agn.nota_fiscal_worket.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NotaFiscal {
    private Long id;
    private String pedidoId;
}
