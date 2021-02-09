package br.app.bikelock.appbikelock.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Bicicleta {
    
    @Id
    @Column(name="idBicicleta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String numeroSerie;
    private String tag;
    private TipoBicicleta tipo;
    private String marca;
    private String modelo;
    private String cor;
    private TipoQuadro tipoQuadro;
    private String informacoesAdicionais;

}
