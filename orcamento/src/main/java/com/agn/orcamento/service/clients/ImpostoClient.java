package com.agn.orcamento.service.clients;

import com.agn.orcamento.model.ImpostoResponsePayload;
import com.agn.orcamento.model.Peca;
import com.agn.orcamento.model.PecaRequest;
import com.agn.orcamento.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("IMPOSTO")
public interface ImpostoClient {
    @PostMapping("/")
    ImpostoResponsePayload calcularImposto(@RequestBody PecaRequest pecaRequest);

}