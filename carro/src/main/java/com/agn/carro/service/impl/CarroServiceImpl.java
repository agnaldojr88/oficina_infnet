package com.agn.carro.service.impl;

import com.agn.carro.model.Carro;
import com.agn.carro.repository.CarroRepository;
import com.agn.carro.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {
    private final CarroRepository carroRepository;

    @Override
    public Carro create(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Optional<Carro> findById(Long id) {
        return carroRepository.findById(id);
    }

    @Override
    public List<Carro> findAll() {
        return carroRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        carroRepository.deleteById(id);
    }

    @Override
    public Carro update(Carro carro) {
        return carroRepository.save(carro);
    }
}