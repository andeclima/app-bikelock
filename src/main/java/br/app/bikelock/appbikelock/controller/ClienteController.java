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

import br.app.bikelock.appbikelock.dto.BicicletaDTO;
import br.app.bikelock.appbikelock.dto.ClienteDTO;
import br.app.bikelock.appbikelock.model.Bicicleta;
import br.app.bikelock.appbikelock.model.Cliente;
import br.app.bikelock.appbikelock.service.ClienteService;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteDTO>> lista() {
        List<Cliente> lista = service.lista();
        List<ClienteDTO> listaDTO = new ArrayList<>();
        for (Cliente cliente:lista) {
            listaDTO.add(converteClienteDto(cliente));
        }
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<ClienteDTO> busca(@PathVariable Long id) {
        Cliente clienteEncontrado = service.busca(id);
        if (clienteEncontrado != null) {
            return ResponseEntity.ok().body(converteClienteDto(clienteEncontrado));
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/clientes")
    public ResponseEntity<ClienteDTO> adiciona(@RequestBody ClienteDTO dto) {
        Cliente cliente = converteDtoCliente(dto);
        Cliente novo = service.adiciona(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(converteClienteDto(novo));
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClienteDTO> atualiza(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteEncontrado = service.busca(id);
        if (clienteEncontrado != null) {
            if (clienteEncontrado.getId().equals(cliente.getId())) {
                clienteEncontrado = service.atualiza(cliente);
                return ResponseEntity.ok().body(converteClienteDto(clienteEncontrado));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<ClienteDTO> remove(@PathVariable Long id) {
        Cliente clienteEncontrado = service.busca(id);
        if (clienteEncontrado != null) {
            service.remove(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Métodos de controle de requisições de bicicletas...
    @GetMapping("/clientes/{idCliente}/bicicletas")
    public ResponseEntity<List<BicicletaDTO>> listaBicicleta(@PathVariable Long idCliente) {
        List<Bicicleta> lista = service.listaBicicleta(idCliente);
        if (lista != null) {
            List<BicicletaDTO> listaDto = new ArrayList<>();
            for (Bicicleta bicicleta:lista) {
                listaDto.add(converteBicicletaDto(bicicleta));
            }
            return ResponseEntity.ok().body(listaDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clientes/{idCliente}/bicicletas/{id}")
    public ResponseEntity<BicicletaDTO> buscaBicicleta(@PathVariable Long idCliente, @PathVariable Long id) {
        Bicicleta bicicletaEncontrada = service.buscaBicicleta(idCliente, id);
        if (bicicletaEncontrada != null) {
            return ResponseEntity.ok().body(converteBicicletaDto(bicicletaEncontrada));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes/{idCliente}/bicicletas")
    public ResponseEntity<BicicletaDTO> adicionaBicicleta(@PathVariable Long idCliente, @RequestBody BicicletaDTO dto) {
        Bicicleta bicicleta = converteDtoBicicleta(dto);
        Bicicleta novaBicicleta = service.adicionaBicicleta(idCliente, bicicleta);
        if (novaBicicleta != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(converteBicicletaDto(novaBicicleta));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/clientes/{idCliente}/bicicletas")
    public ResponseEntity<BicicletaDTO> atualizaBicicleta(@PathVariable Long idCliente, @RequestBody BicicletaDTO dto) {
        Bicicleta bicicleta = converteDtoBicicleta(dto);
        Bicicleta bicicletaAtualizada = service.atualizaBicicleta(idCliente, bicicleta);
        if (bicicletaAtualizada != null) {
            return ResponseEntity.ok().body(converteBicicletaDto(bicicletaAtualizada));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/clientes/{idCliente}/bicicletas/{id}")
    public ResponseEntity<BicicletaDTO> removeBicicleta(@PathVariable Long idCliente, @PathVariable Long id) {
        Cliente clienteEncontrado = service.busca(idCliente);
        if (clienteEncontrado != null) {
            service.removeBicicleta(idCliente, id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
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

    private BicicletaDTO converteBicicletaDto(Bicicleta bicicleta) {
        BicicletaDTO dto = new BicicletaDTO();
        dto.setId(bicicleta.getId());
        dto.setNome(bicicleta.getNome());
        dto.setNumeroSerie(bicicleta.getNumeroSerie());
        dto.setTag(bicicleta.getTag());
        dto.setTipo(bicicleta.getTipo());
        dto.setMarca(bicicleta.getMarca());
        dto.setModelo(bicicleta.getModelo());
        dto.setCor(bicicleta.getCor());
        dto.setTipoQuadro(bicicleta.getTipoQuadro());
        dto.setInformacoesAdicionais(bicicleta.getInformacoesAdicionais());
        return dto;
    }

    private Bicicleta converteDtoBicicleta(BicicletaDTO dto) {
        Bicicleta bicicleta = new Bicicleta();
        bicicleta.setId(dto.getId());
        bicicleta.setNome(dto.getNome());
        bicicleta.setNumeroSerie(dto.getNumeroSerie());
        bicicleta.setTag(dto.getTag());
        bicicleta.setTipo(dto.getTipo());
        bicicleta.setMarca(dto.getMarca());
        bicicleta.setModelo(dto.getModelo());
        bicicleta.setCor(dto.getCor());
        bicicleta.setTipoQuadro(dto.getTipoQuadro());
        bicicleta.setInformacoesAdicionais(dto.getInformacoesAdicionais());
        return bicicleta;
    }
}
