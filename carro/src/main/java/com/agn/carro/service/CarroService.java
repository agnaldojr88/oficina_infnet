package com.agn.carro.service;

import com.agn.carro.model.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroService {
    Carro create(Carro carro);
    Optional<Carro> findById(Long id);
    List<Carro> findAll();
    void deleteById(Long id);
    Carro update(Carro carro);

}
