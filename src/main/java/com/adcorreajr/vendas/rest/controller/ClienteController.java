package com.adcorreajr.vendas.rest.controller;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.repository.ClienteRepository;
import io.swagger.annotations.*;
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
@Api("Api Clientes")
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/{id}")
    @ApiOperation("Obter detalhes de um cliente.")
    @ApiResponses({
            @ApiResponse(code = 200,  message = "Cliente encontrado."),
            @ApiResponse(code = 404, message = "Cliente não encontrado.")
    })
    public Cliente getClienteById(@PathVariable @ApiParam("Id do cliente") Integer id){
        return  clienteRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cria um cliente.")
    @ApiResponses({
            @ApiResponse(code = 201,  message = "Cliente gravado."),
            @ApiResponse(code = 404, message = "Cliente não encontrado."),
            @ApiResponse(code = 400, message = "Dados invalidos")
    })
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
