package com.agn.orcamento.service.clients;

import com.agn.orcamento.model.Carro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CARRO")
public interface CarroClient {
    @GetMapping("/{id}")
    Carro getById(@PathVariable("id") Long id);
}