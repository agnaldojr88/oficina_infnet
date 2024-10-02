package com.agn.orcamento.service;

import com.agn.orcamento.model.Cerveja;
import com.agn.orcamento.service.clients.CervejaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CervejaService {

    private final CervejaClient cervejaClient;

    public Cerveja getById(Long id){

        return  cervejaClient.getById(id);
        //var serverUrl = String.format("http://localhost:8081/%d", id);
        //RestClient restClient = RestClient.create();
        //return restClient
        //        .get()
        //        .uri(serverUrl)
        //        .retrieve()
        //        .toEntity(Cerveja.class).getBody();
    }
}
