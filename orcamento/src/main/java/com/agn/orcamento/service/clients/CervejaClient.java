package com.agn.orcamento.service.clients;

import com.agn.orcamento.model.Cerveja;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CERVEJA")
public interface CervejaClient {
    @GetMapping("/{id}")
    Cerveja getById(@PathVariable("id") Long id);
}