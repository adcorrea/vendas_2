package com.adcorreajr.vendas.domain.repository;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    //Busca pedidos do Cliente
    List<Pedido> findByCliente(Cliente cliente);
}
