package com.adcorreajr.vendas.service.impl;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.entity.ItemPedido;
import com.adcorreajr.vendas.domain.entity.Pedido;
import com.adcorreajr.vendas.domain.entity.Produto;
import com.adcorreajr.vendas.domain.repository.ClienteRepository;
import com.adcorreajr.vendas.domain.repository.ItemPedidoRepository;
import com.adcorreajr.vendas.domain.repository.PedidoRepository;
import com.adcorreajr.vendas.domain.repository.ProdutoRepository;
import com.adcorreajr.vendas.exceptions.RegraNegocioException;
import com.adcorreajr.vendas.rest.dto.ItemPedidoDTO;
import com.adcorreajr.vendas.rest.dto.PedidoDTO;
import com.adcorreajr.vendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {


    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido save(PedidoDTO pedidoDTO)  {
        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setTotal(pedidoDTO.getTotal());

        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente())
                .orElseThrow(() -> new RegraNegocioException("Cliente Não Encontrado"));

        pedido.setCliente(cliente);

        pedido = pedidoRepository.save(pedido);
        pedido.setItemPedidos(itemPedidoRepository
                                            .saveAll(converterItems(pedido, pedidoDTO.getItems())));

        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> itemsPedido){

        if(itemsPedido.isEmpty())
            throw new RegraNegocioException("Liste de itens do pedido está vazia.");

        return itemsPedido.stream()
                .map( dto -> {
                    Produto produto = produtoRepository.findById(dto.getProduto())
                            .orElseThrow(()-> new RegraNegocioException("Produto Não Encontrado"));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setProduto(produto);
                    itemPedido.setPedido(pedido);
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setQuantidade(dto.getQuantidade());

                    return itemPedido;
                }).collect(Collectors.toList());
    }
}


