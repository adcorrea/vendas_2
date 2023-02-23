package com.adcorreajr.vendas.domain.repository;

import com.adcorreajr.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
