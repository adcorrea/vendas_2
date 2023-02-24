package com.adcorreajr.vendas.rest.controller;

import com.adcorreajr.vendas.domain.entity.Cliente;
import com.adcorreajr.vendas.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;

    @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nome){
        return String.format("Hello %s", nome);
    }


    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id){
        Optional<Cliente> cliente =  clienteRepository.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente){
        Cliente newCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(newCliente);
    }

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity getAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteById(@PathVariable Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Cliente cliente){
        return clienteRepository
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clienteRepository.save(cliente);
                    return ResponseEntity.noContent().build();
                    } )
                .orElseGet(() -> ResponseEntity.notFound().build());

    }
}
