package com.adcorreajr.vendas.exceptions;

public class SenhaInvalidaException extends RuntimeException{

    public SenhaInvalidaException(){
        super("Senha inválida.");
    }
}
