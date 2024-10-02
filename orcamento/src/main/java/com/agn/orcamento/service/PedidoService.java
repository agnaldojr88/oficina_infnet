package com.agn.orcamento.service;

import com.agn.orcamento.model.Cerveja;
import com.agn.orcamento.model.ItemPedido;
import com.agn.orcamento.model.Pedido;
import com.agn.orcamento.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final CervejaService cervejaService;
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public BigDecimal calcularValorTotal(Pedido pedido){
        return pedido.getItens().stream()
                .map(this::calcularValorDeItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularValorDeItem(ItemPedido item){
        Cerveja cerveja = cervejaService.getById(item.getCervejaId());
        return cerveja.getPreco().multiply(new BigDecimal(item.getQuantidade()));
    }
}
