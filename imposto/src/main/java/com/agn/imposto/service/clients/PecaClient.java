package com.agn.imposto.service.clients;


import com.agn.imposto.model.Peca;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PECA")
public interface PecaClient {
    @GetMapping("/{id}")
    Peca getById(@PathVariable("id") Long id);
}