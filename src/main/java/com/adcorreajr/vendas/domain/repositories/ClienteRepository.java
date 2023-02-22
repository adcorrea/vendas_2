package com.adcorreajr.vendas.domain.repositories;

import com.adcorreajr.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //Busca por nome usando o like do SQL
    List<Cliente> findByNomeLike(String nome);

    //Busca por nome ou id
    List<Cliente> findByNomeOrId(String nome, Integer id);


    //Busca por nome ou id e orderna por id
    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    //Busca por ome e retorna apenas um registro
    Cliente findOneByNome(String nome);

    //Retornar verdadeiro ou falso se o nome existe
    boolean existsByNome(String nome);
}
