package com.agn.orcamento.model;

import java.util.List;

public record OrcamentoPayload(Orcamento orcamento, List<Peca> itens, Carro carro) {
}
