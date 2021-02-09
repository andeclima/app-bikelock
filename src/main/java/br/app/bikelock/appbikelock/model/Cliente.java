package br.app.bikelock.appbikelock.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Cliente {
    
    @Id
    @Column(name="idCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String municipio;
    private String uf;
    private String telefone;

    @OneToMany
    @JoinColumn(name = "idCliente")
    private List<Bicicleta> bicicletas;

    public Cliente() {
        this.bicicletas = new ArrayList<>();
    }

    public void adicionaBicicleta(Bicicleta bicicleta) {
        this.bicicletas.add(bicicleta);
    }

    public void removeBicicleta(Bicicleta bicicleta) {
        this.bicicletas.remove(bicicleta);
    }

}
