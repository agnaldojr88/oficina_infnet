package com.agn.imposto.service;

import com.agn.imposto.model.Peca;
import com.agn.imposto.service.clients.PecaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PecaService {

    private final PecaClient pecaClient;

    public Peca getById(Long id){

        return pecaClient.getById(id);

    }

}
