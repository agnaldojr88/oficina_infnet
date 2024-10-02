package com.agn.orcamento.service.clients;

import com.agn.orcamento.model.Peca;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PECA")
public interface PecaClient {
    @GetMapping("/{id}")
    Peca getById(@PathVariable("id") Long id);
}