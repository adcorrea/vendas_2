package com.adcorreajr.vendas.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    @NotEmpty(message = "Descrição é obrigatório!")
    private String descricao;

    @Column(name = "preco_unitario")
    @NotNull(message = "Preço é obrigatório!")
    private BigDecimal preco;

}
