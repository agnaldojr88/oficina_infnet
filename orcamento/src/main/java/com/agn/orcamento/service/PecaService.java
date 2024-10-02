package com.agn.orcamento.service;

import com.agn.orcamento.model.Peca;
import com.agn.orcamento.service.clients.PecaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PecaService {

    private final PecaClient pecaClient;

    public Peca getById(Long id){
        return  pecaClient.getById(id);
    }
}
