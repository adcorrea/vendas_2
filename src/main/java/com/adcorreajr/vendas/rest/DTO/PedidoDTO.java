package com.adcorreajr.vendas.rest.dto;

import com.adcorreajr.vendas.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    @NotNull(message = "Cliente é obrigatório")
    private Integer cliente;

    @NotNull(message = "Total do pedido é obrigatório")
    private BigDecimal total;

    @NotEmptyList(message = "Pedido não pode ser realizado sem itens.")
    private List<ItemPedidoDTO> items;
}
