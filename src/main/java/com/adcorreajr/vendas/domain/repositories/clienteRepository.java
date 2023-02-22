package com.adcorreajr.vendas.domain.repositories;

import com.adcorreajr.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Integer> {
}
