package com.agn.orcamento.service;

import com.agn.orcamento.model.ImpostoResponsePayload;
import com.agn.orcamento.model.Peca;
import com.agn.orcamento.model.PecaRequest;
import com.agn.orcamento.model.Pedido;
import com.agn.orcamento.service.clients.ImpostoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImpostoService {


    private final ImpostoClient impostoClient;

    public ImpostoResponsePayload getTotalImposto(PecaRequest pecas) {

        return impostoClient.calcularImposto(pecas);

    }

}
