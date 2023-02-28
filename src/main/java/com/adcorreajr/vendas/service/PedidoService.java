package com.adcorreajr.vendas.service;

import com.adcorreajr.vendas.domain.entity.Pedido;
import com.adcorreajr.vendas.rest.dto.AtualizacaoStatusPedidoDTO;
import com.adcorreajr.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {


    Pedido save(PedidoDTO pedido);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizarStatus(Integer id, String status);
}
