package com.agn.orcamento.service;

import com.agn.orcamento.service.clients.NotaFiscalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalClient notaFiscalClient;

    public void emitir(String pedidoId){
        notaFiscalClient.emitir(pedidoId);
    }
}
