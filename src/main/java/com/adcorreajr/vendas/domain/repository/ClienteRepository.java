package com.adcorreajr.vendas.domain.repository;

import com.adcorreajr.vendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    //Busca por nome usando HQL
    @Query(value = " select c from Cliente c where c.nome like :nome ")
    List<Cliente> buscarPorNomeLikeHQL( @Param("nome") String nome);

    //Busca por nome usando SQL nativo. Obs, nao funciona.
    @Query(value = " select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> buscarPorNomeLikeSQL(@Param("nome") String nome);


    //Deleta por nome usando HQL. Precisa colocar a anotação @Modifying quando realizar INSERT, UPDATE ou DELETE
    @Query(value = " delete from Cliente c where c.nome = :nome ")
    @Modifying
    void deleteByNomeHQL(String nome);

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


    //Carrega o cliente e os pedidos.
    //Por padrão, relacionamentos do MappedBy são do tipo Fetch LAZY, por isso precisam ser
    //explicitamentes carregados
    @Query(value = " select c from Cliente c join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFechPedido( @Param("id") Integer id);
}
