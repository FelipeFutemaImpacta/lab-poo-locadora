package br.com.impacta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/locadora")
public class LocadoraController {

	@Autowired
	private Locadora locadora;
	
	@GetMapping("/veiculos")
	public ResponseEntity<Veiculo[]> buscarVeiculos(@RequestParam(required = false) String modelo) {
		
		if (modelo == null) {
			return ResponseEntity.ok(locadora.listarTodosVeiculos(false));			
		} else {
			Veiculo[] veiculos =  new Veiculo[1];
			veiculos[0] = locadora.buscarVeiculoPorModelo(modelo);
			return ResponseEntity.ok(veiculos);
		}
	}
	
	@GetMapping("/veiculos/{modelo}")
	public ResponseEntity<Veiculo> buscarVeiculoPorModelo(@PathVariable String modelo) {
		
		Veiculo veiculo = locadora.buscarVeiculoPorModelo(modelo);
		
		return ResponseEntity.ok(veiculo);
	}

	
	@PostMapping("/veiculos")
	public ResponseEntity<Void> criaVeiculo(@RequestBody Veiculo veiculo) {
		
		System.out.println(veiculo.toString());
		
		return ResponseEntity.created(null).build();
	}
	
}
