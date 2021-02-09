package br.app.bikelock.appbikelock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.app.bikelock.appbikelock.model.Bicicleta;
import br.app.bikelock.appbikelock.model.Cliente;
import br.app.bikelock.appbikelock.model.TipoBicicleta;
import br.app.bikelock.appbikelock.model.TipoQuadro;

@SpringBootApplication
public class AppBikelockApplication {

	public static void main(String[] args) {

		// Cliente c1 = new Cliente();
		// c1.setNome("Fulano de Tal");
		// c1.setEmail("fulano@gmail.com");
		// c1.setMunicipio("Teresina");
		// c1.setUf("PI");

		// Bicicleta trilha = new Bicicleta();
		// trilha.setNome("Fuscão Preto");
		// trilha.setMarca("Caloi");
		// trilha.setModelo("Barra circular");
		// trilha.setTipo(TipoBicicleta.MOUNTAIN_BIKE);
		// trilha.setTipoQuadro(TipoQuadro.ALUMINIO);

		// c1.getBicicletas().add(trilha);

		SpringApplication.run(AppBikelockApplication.class, args);

	}

}
