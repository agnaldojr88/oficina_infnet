package com.agn.peca.service;

import com.agn.peca.model.Disponibilidade;
import com.agn.peca.model.Peca;
import com.agn.peca.repository.PecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PecaService {
    private final PecaRepository pecaRepository;

    public List<Peca> getAll(){
        return pecaRepository.findAll();
    }

    public Optional<Peca> getById(Long id){
        return pecaRepository.findById(id);
    }

    public Peca updateQuantEmEstoque(Peca peca, Integer quant){

        peca.setQuantEmEstoque(quant);

        if(peca.getQuantEmEstoque() == 0){
            peca.setDisponibilidade(Disponibilidade.INDISPONIVEL);
        }

        return pecaRepository.save(peca);
    }


    public Peca salvar(Peca peca){
        return pecaRepository.save(peca);
    }

}
