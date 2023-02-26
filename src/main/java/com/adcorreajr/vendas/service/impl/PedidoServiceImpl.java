package com.adcorreajr.vendas.service.impl;

import com.adcorreajr.vendas.domain.repository.PedidoRepository;
import com.adcorreajr.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
}
