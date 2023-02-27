package com.adcorreajr.vendas.service;

import com.adcorreajr.vendas.domain.entity.Pedido;
import com.adcorreajr.vendas.rest.dto.PedidoDTO;

public interface PedidoService {


    Pedido save(PedidoDTO pedido);
}
