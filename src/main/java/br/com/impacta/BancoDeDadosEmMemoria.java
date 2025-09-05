package br.com.impacta;

public class BancoDeDadosEmMemoria implements BancoDeDados {
	private Veiculo[] veiculos;

	public BancoDeDadosEmMemoria() {
		veiculos = new Veiculo[6];

		veiculos[0] = new Carro("HB20", "Hyundai", 80, 0.3, true, "Hatch");
		veiculos[1] = new Carro("Gol", "Volkswagen", 70, 0.4, true, "Hatch");
		veiculos[2] = new Carro("Corolla", "Toyota", 120, 0.5, true, "Sedan");

		veiculos[3] = new Moto("CB600", "Honda", 60, 0.2, true, 600);
		veiculos[4] = new Moto("Bis", "Honda", 30, 0.1, true, 125);
		veiculos[5] = new Moto("Factor", "Yamaha", 40, 0.15, true, 150);
	}

	@Override
	public Veiculo[] buscarTodosVeiculos() {
		return veiculos;
	}

	@Override
	public String getNomeBanco() {
		return "Banco Principal";
	}
}