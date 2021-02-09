package br.app.bikelock.appbikelock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.app.bikelock.appbikelock.dto.ClienteDTO;
import br.app.bikelock.appbikelock.model.Cliente;
import br.app.bikelock.appbikelock.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> lista() {
        List<Cliente> lista = clienteService.lista();
        List<ClienteDTO> listaDTO = new ArrayList<>();
        for (Cliente cliente:lista) {
            listaDTO.add(converteClienteDto(cliente));
        }
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteDTO> busca(@PathVariable Long id) {
        Cliente clienteEncontrado = clienteService.busca(id);
        return ResponseEntity.ok().body(converteClienteDto(clienteEncontrado));
    }
    
    @PostMapping("/clientes")
    public ResponseEntity<ClienteDTO> adiciona(@RequestBody ClienteDTO dto) {
        Cliente cliente = converteDtoCliente(dto);
        Cliente novo = clienteService.adiciona(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(converteClienteDto(novo));
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClienteDTO> atualiza(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente encontrado = clienteService.busca(id);
        if (encontrado != null) {
            if (encontrado.getId().equals(cliente.getId())) {
                encontrado = clienteService.atualiza(cliente);
                return ResponseEntity.ok().body(converteClienteDto(encontrado));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<ClienteDTO> remove(@PathVariable Long id) {
        Cliente encontrado = clienteService.busca(id);
        if (encontrado != null) {
            clienteService.remove(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private ClienteDTO converteClienteDto(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setEmail(cliente.getEmail());
        dto.setSenha(cliente.getSenha());
        dto.setCpf(cliente.getCpf());
        dto.setTelefone(cliente.getTelefone());
        dto.setMunicipio(cliente.getMunicipio());
        dto.setUf(cliente.getUf());
        return dto;
    }

    private Cliente converteDtoCliente(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setSenha(dto.getSenha());
        cliente.setCpf(dto.getCpf());
        cliente.setTelefone(dto.getTelefone());
        cliente.setMunicipio(dto.getMunicipio());
        cliente.setUf(dto.getUf());
        return cliente;
    }
}
