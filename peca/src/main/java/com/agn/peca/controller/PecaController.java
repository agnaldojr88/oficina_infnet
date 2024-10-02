package com.agn.peca.controller;


import com.agn.peca.model.Peca;
import com.agn.peca.service.PecaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class PecaController {

     private final PecaService pecaService;

     @GetMapping
     public ResponseEntity<List<Peca>> getAll(){
         return ResponseEntity.ok(pecaService.getAll());
     }

     @GetMapping("/{id}")
     public ResponseEntity<?> getById(@PathVariable long id){
         log.info("Get Peça by id: {}", id);
         Optional<Peca> optional = pecaService.getById(id);
         if(optional.isPresent()){
             return ResponseEntity.ok(optional.get());
         }else{
             return ResponseEntity.notFound().build();
         }
     }


     @PostMapping
     public ResponseEntity<Peca> create(@RequestBody Peca peca){

         log.info("Novo cadastro de peça: {}", peca);

         Peca saved = pecaService.salvar(peca);

         return ResponseEntity.ok(saved);
     }


    @PostMapping("/{id}/estoque")
    public ResponseEntity<?> updateQuantEmEstoque(@RequestBody Peca peca, @PathVariable int estoque){

        log.info("Atualizando quantidade em estoque da peça: {}", peca);

        return ResponseEntity.ok(pecaService.updateQuantEmEstoque(peca, estoque));

    }

}
