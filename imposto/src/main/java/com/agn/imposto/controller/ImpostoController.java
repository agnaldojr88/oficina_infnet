package com.agn.imposto.controller;


import com.agn.imposto.model.PecaPayload;
import com.agn.imposto.service.ImpostoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class ImpostoController {

    private final ImpostoService impostoService;

    @PostMapping
    public ResponseEntity calcularImposto(@RequestBody PecaPayload pecaPayload){

        log.info("Calculando imposto das peças no total - payload {}", pecaPayload);
        BigDecimal impostoTotal = impostoService.calcularImpostoTotal(pecaPayload);

        return ResponseEntity.ok(Map.of("totalImposto", impostoTotal));
    }
}
