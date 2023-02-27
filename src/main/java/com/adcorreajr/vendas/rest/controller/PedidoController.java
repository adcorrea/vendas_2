package com.adcorreajr.vendas.rest.controller;


import com.adcorreajr.vendas.domain.entity.Pedido;
import com.adcorreajr.vendas.rest.dto.InformacoesPedidoDTO;
import com.adcorreajr.vendas.rest.dto.ItemPedidoDTO;
import com.adcorreajr.vendas.rest.dto.PedidoDTO;
import com.adcorreajr.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    /*
    @GetMapping("/{id}")
    public InformacoesPedidoDTO getById(@PathVariable Integer id){
        return pedidoService.obterPedidoCompleto(id)
                .map()
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND),"Pedido não encontrado");
    }
    
     */

}
