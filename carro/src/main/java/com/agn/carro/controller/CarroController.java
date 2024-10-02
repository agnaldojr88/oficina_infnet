package com.agn.carro.controller;

import com.agn.carro.model.Carro;
import com.agn.carro.model.HistoricoRevisao;
import com.agn.carro.service.CarroService;
import com.agn.carro.service.HistoricoRevisaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j //Msg de log
public class CarroController {

    private final CarroService carroService;
    private final HistoricoRevisaoService historicoRevisaoService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(carroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        log.info("Find Carro by ID {}", id);
        Optional<Carro> carro = carroService.findById(id);
        if(carro.isPresent()) {
            return ResponseEntity.ok(carro.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }




    @GetMapping("/{id}/complete")
    public ResponseEntity<?> findByIdComRevisoes(@PathVariable long id) {
        log.info("Find Carro by ID {}", id);

        Optional<Carro> optCarro = carroService.findById(id);


        if(optCarro.isPresent()) {
            List<HistoricoRevisao> allById =  historicoRevisaoService.findAllByCarro(optCarro.get());

            return ResponseEntity.ok(allById);
        }else{
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        carroService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Carro carro) {
        Carro saved = carroService.create(carro);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Carro carro) {
        carroService.update(carro);
        return ResponseEntity.ok().build();
    }
}
