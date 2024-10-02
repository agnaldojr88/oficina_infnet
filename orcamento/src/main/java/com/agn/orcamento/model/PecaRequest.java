package com.agn.orcamento.model;

import java.util.List;

public class PecaRequest {

    private List<Peca> pecas;

    // Construtor padrão
    public PecaRequest() {}

    // Construtor com parâmetros
    public PecaRequest(List<Peca> pecas) {
        this.pecas = pecas;
    }

    // Getters e Setters
    public List<Peca> getPecas() {
        return pecas;
    }

    public void setPecas(List<Peca> pecas) {
        this.pecas = pecas;
    }

}
