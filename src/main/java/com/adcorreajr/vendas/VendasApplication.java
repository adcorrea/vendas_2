package com.adcorreajr.vendas;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.entity.Pedido;
import com.adcorreajr.vendas.domain.repository.ClienteRepository;
import com.adcorreajr.vendas.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//Classe SpringBootServletInitializer faz com que a aplicação seja web (arquivo war)
//precisa da dependencia do springboot.starter.tomcat

@SpringBootApplication
public class VendasApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}


	//CommandLineRunner executa blocos de codigo na inicialização do projeto. Util para testes.

	/*
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository
									, @Autowired PedidoRepository pedidoRepository){
		return args -> {
			System.out.println("Salvando clientes");

			clienteRepository.save(new Cliente("Junior"));


		};
	}
	*/



}

