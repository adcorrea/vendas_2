package com.adcorreajr.vendas.domain.repository;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    //Busca pedidos do Cliente
    List<Pedido> findByCliente(Cliente cliente);

    Optional<Pedido> findByIdFetchItemPedidos(Integer integer);
}
