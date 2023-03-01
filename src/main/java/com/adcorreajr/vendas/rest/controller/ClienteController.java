package com.adcorreajr.vendas.rest.controller;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id){
        return  clienteRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @GetMapping("/")
    public List<Cliente> getAll(){
        return  clienteRepository.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        clienteRepository
                .findById(id)
                .map(cliente ->
                        {
                            clienteRepository.delete(cliente);
                            return Void.TYPE;
                        }
                )
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente Não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Cliente cliente){
        clienteRepository
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return  Void.TYPE;
                } )
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @GetMapping("/filtro")
    public List<Cliente> find (Cliente filtro){

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);

        List<Cliente> lista = clienteRepository.findAll(example);

        return lista;
    }
}
