package com.agn.orcamento.service;

import com.agn.orcamento.model.Carro;
import com.agn.orcamento.service.clients.CarroClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroClient carroClient;

    public Carro getById(Long id){
        return  carroClient.getById(id);
    }
}
