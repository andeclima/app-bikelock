package br.app.bikelock.appbikelock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.bikelock.appbikelock.model.Cliente;
import br.app.bikelock.appbikelock.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> lista() {
        return clienteService.lista();
    }
    
    @PostMapping("/clientes")
    public String post() {
        return "Verbo POST";
    }

    @PutMapping("/clientes")
    public String put() {
        return "Verbo PUT";
    }

    @DeleteMapping("/clientes")
    public String delete() {
        return "Verbo DELETE";
    }
}
