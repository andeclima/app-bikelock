package br.app.bikelock.appbikelock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import br.app.bikelock.appbikelock.model.Bicicleta;
import br.app.bikelock.appbikelock.model.Cliente;
import br.app.bikelock.appbikelock.model.TipoBicicleta;
import br.app.bikelock.appbikelock.model.TipoQuadro;
import br.app.bikelock.appbikelock.repository.BicicletaRepository;
import br.app.bikelock.appbikelock.repository.ClienteRepository;

@SpringBootApplication
public class AppBikelockApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BicicletaRepository bicicletaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppBikelockApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente();
		c1.setNome("Fulano de Tal");
		c1.setEmail("fulano@gmail.com");
		c1.setMunicipio("Teresina");
		c1.setUf("PI");
		// clienteRepository.save(c1);

		Bicicleta b1 = new Bicicleta();
		b1.setNome("Fuscão Preto");
		b1.setMarca("Caloi");
		b1.setModelo("Barra circular");
		b1.setTipo(TipoBicicleta.MOUNTAIN_BIKE);
		b1.setTipoQuadro(TipoQuadro.ALUMINIO);

		bicicletaRepository.save(b1);
		
		c1.adicionaBicicleta(b1);

		Bicicleta b2 = new Bicicleta();
		b2.setNome("Princesa");
		b2.setMarca("Caloi");
		b2.setModelo("Elite 10");
		b2.setTipo(TipoBicicleta.ESTRADA);
		b2.setTipoQuadro(TipoQuadro.CARBONO);
		
		bicicletaRepository.save(b2);

		c1.adicionaBicicleta(b2);

		clienteRepository.save(c1);

	}

}
