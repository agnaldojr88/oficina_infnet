package com.agn.orcamento.repository;

import com.agn.orcamento.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {


}
