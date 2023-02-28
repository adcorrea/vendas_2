package com.adcorreajr.vendas.exceptions;

public class PedidoNaoEncontradoException extends RuntimeException{

    public PedidoNaoEncontradoException(String message){
        super(message);
    }
}
