package com.adcorreajr.vendas.domain.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;


    /*
    Mapeamento para pedidos, não esta no modelo logico, mas essa tecnica é usada
    para listar os pedidos do cliente.
    O mappedBy tem a propriedade da classe Pedido que contem o relacionamento a classe Cliente
    que no caso é o cliente.
    */
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;

    public Cliente(){}

    public Cliente(Integer id, String nome){
        this.nome = nome;
        this.id = id;
    }

    public Cliente(String nome){
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {

        return "Id: " + this.id.toString() + " Nome: " + nome;
                //+ " Pedido: " + pedidos;
    }
}
