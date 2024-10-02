package com.agn.orcamento.repository;

import com.agn.orcamento.model.Orcamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrcamentoRepository extends MongoRepository<Orcamento, String> {


}
