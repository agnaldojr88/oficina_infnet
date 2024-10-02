package com.agn.orcamento.controller;


import com.agn.orcamento.model.Orcamento;
import com.agn.orcamento.model.Peca;
import com.agn.orcamento.model.PecaRequest;
import com.agn.orcamento.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class OrcamentoController {

    private final CarroService carroService;
    private final PecaService pecaService;

    private final PedidoService pedidoService;
    private final ImpostoService impostoService;
    private final NotaFiscalService notaFiscalService;
    private final OrcamentoService orcamentoService;




    @PostMapping
    public ResponseEntity create(@RequestBody Orcamento orcamento) {


        log.info("Iniciando processo de Orçamento  {}", orcamento);



        //Calcula valor total das peças do Orçamento
        PecaRequest pecaRequest = new PecaRequest(orcamento.getPecas());
        BigDecimal totalValor = orcamentoService.calcularValorTotal(pecaRequest);
        orcamento.setPreco(totalValor);

        //Calcula o valor do imposto com base nas peças enviadas ao Microserviço - IMPOSTO
        BigDecimal totalImposto = impostoService.getTotalImposto(pecaRequest).totalImposto();
        orcamento.setValorImposto(totalImposto);

        orcamentoService.salvar(orcamento);

        //Emite nota fiscal
        notaFiscalService.emitir(orcamento.getId());


        log.info("Pedido lançado e com pedido de NF enviado {}", orcamento);

        return ResponseEntity.ok(Map.of("orcamento", orcamento));
    }

    @GetMapping
    public ResponseEntity<List<Orcamento>> getAll(){
        return ResponseEntity.ok(orcamentoService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        log.info("Find Orcamento by ID {}", id);
        Optional<Orcamento> orcamento = orcamentoService.getById(id);
        if(orcamento.isPresent()) {
            return ResponseEntity.ok(orcamento.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
