package com.adcorreajr.vendas.rest.controller;


import com.adcorreajr.vendas.domain.entity.Pedido;
import com.adcorreajr.vendas.rest.dto.ItemPedidoDTO;
import com.adcorreajr.vendas.rest.dto.PedidoDTO;
import com.adcorreajr.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;


    @PostMapping({"/",""})
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO pedidoDTO){
        Pedido pedido = pedidoService.save(pedidoDTO);
        return pedido.getId();
    }

}
