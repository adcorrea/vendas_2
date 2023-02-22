package com.adcorreajr.vendas;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendasApplication.class, args);
	}


	//CommandLineRunner executa blocos de codigo na inicialização do projeto. Util para testes.
	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
		return args -> {
			System.out.println("Salvando clientes");
			clienteRepository.save(new Cliente("Junior"));
			clienteRepository.save(new Cliente("Douglas"));

			List<Cliente> todosClientes = clienteRepository.findByNomeLike("Junior");
			todosClientes.forEach(System.out::println);
		};
	}

}

