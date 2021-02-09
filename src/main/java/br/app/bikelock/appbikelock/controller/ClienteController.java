package br.app.bikelock.appbikelock.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public String get() {
        return "Verbo GET";
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
