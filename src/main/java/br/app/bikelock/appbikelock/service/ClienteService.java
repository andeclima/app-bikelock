package br.app.bikelock.appbikelock.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.app.bikelock.appbikelock.model.Bicicleta;
import br.app.bikelock.appbikelock.model.Cliente;
import br.app.bikelock.appbikelock.repository.BicicletaRepository;
import br.app.bikelock.appbikelock.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BicicletaRepository bicicletaRepository;

    // Listar todos os clientes
    public List<Cliente> lista() {
        return clienteRepository.findAll();
    }

    // Buscar um cliente específico
    public Cliente busca(Long id) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
        return clienteEncontrado.orElse(null);
    }

    // Buscar um cliente por e-mail
    public Cliente busca(String email) {
        List<Cliente> lista = clienteRepository.findByEmail(email);
        if (lista.size() > 0) {
            return lista.get(0);
        }
        return null;
    }

    // Buscar um cliente por e-mail e senha
    public Cliente login(String email, String senha) {
        List<Cliente> lista = clienteRepository.findByEmail(email);
        if (lista.size() > 0) {
            return lista.get(0);
        }
        return null;
    }

    // Adicionar um cliente
    public Cliente adiciona(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    // Atualizar um cliente
    public Cliente atualiza(Cliente cliente) {
        if (cliente.getId() != null) {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    // Remover um cliente
    public void remove(Long id) {
        clienteRepository.deleteById(id);
    }

    // Métodos de bicicletas

    // Lista as bicicletas de um cliente
    public List<Bicicleta> listaBicicleta(Long idCliente) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            return clienteEncontrado.getBicicletas();
        }
        return null;
    }

    public Bicicleta buscaBicicleta(Long idCliente, Long id) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            for (Bicicleta bicicleta:clienteEncontrado.getBicicletas()) {
                if (bicicleta.getId().equals(id)) {
                    return bicicleta;
                }
            }
        }
        return null;
    }

    @Transactional
    public Bicicleta adicionaBicicleta(Long idCliente, Bicicleta bicicleta) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            bicicleta.setId(null);
            Bicicleta nova = bicicletaRepository.save(bicicleta);
            clienteEncontrado.adicionaBicicleta(bicicleta);
            clienteRepository.save(clienteEncontrado);
            return nova;
        }
        return null;
    }

    public Bicicleta atualizaBicicleta(Long idCliente, Bicicleta bicicleta) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            if (bicicleta.getId() != null) {
                for (Bicicleta item:clienteEncontrado.getBicicletas()) {
                    if (item.getId().equals(bicicleta.getId())) {
                        return bicicletaRepository.save(bicicleta);
                    }
                }
            }
        }
        return null;
    }

    public void removeBicicleta(Long idCliente, Long id) {
        Cliente clienteEncontrado = busca(idCliente);
        if (clienteEncontrado != null) {
            for (Bicicleta item:clienteEncontrado.getBicicletas()) {
                if (item.getId().equals(id)) {
                    bicicletaRepository.deleteById(id);
                }
            }
        }
    }

}
