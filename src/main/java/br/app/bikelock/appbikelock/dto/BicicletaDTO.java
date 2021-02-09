package br.app.bikelock.appbikelock.dto;

import br.app.bikelock.appbikelock.model.TipoBicicleta;
import br.app.bikelock.appbikelock.model.TipoQuadro;
import lombok.Data;

@Data
public class BicicletaDTO {
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
