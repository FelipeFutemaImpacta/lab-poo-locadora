package br.com.impacta;

public class BancoDeDadosEmMemoriaPremium implements BancoDeDados {
	private Veiculo[] veiculos;

	public BancoDeDadosEmMemoriaPremium() {
		veiculos = new Veiculo[4];

		veiculos[0] = new Carro("Civic", "Honda", 100, 0.4, true, "Sedan");
		veiculos[1] = new Carro("Compass", "Jeep", 150, 0.6, true, "SUV");

		veiculos[2] = new Moto("Ninja", "Kawasaki", 80, 0.3, true, 650);
		veiculos[3] = new Moto("R1", "Yamaha", 120, 0.5, true, 1000);
	}

	@Override
	public Veiculo[] buscarTodosVeiculos() {
		return veiculos;
	}

	@Override
	public String getNomeBanco() {
		return "Banco Premium";
	}
}