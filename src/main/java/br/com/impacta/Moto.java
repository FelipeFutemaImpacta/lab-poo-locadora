package br.com.impacta;

public class Moto extends Veiculo {
	private int cilindrada;

	public Moto(String modelo, String marca, double precoDiaria, double precoSeguro, boolean disponivel,
			int cilindrada) {
		super(modelo, marca, precoDiaria, precoSeguro, disponivel);
		this.cilindrada = cilindrada;
	}

	public Moto() {
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public double calcularConsumo() {
		return 25.0;
	}

	@Override
	public void imprimeInfos() {
		super.imprimeInfos();
		System.out.println("Imprimindo infos adicionais de uma moto: ");
		System.out.println("Cilindrada: " + getCilindrada());
	}
	
	@Override
	public String toString() {
		return super.toString() + "Cilindrada: " + getCilindrada();
	}
	
}