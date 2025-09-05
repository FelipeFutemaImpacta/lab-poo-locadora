package br.com.impacta;

public class Carro extends Veiculo {

	private String tipo;

	public Carro(String modelo, String marca, double precoDiaria, double precoSeguro, boolean disponivel, String tipo) {
		super(modelo, marca, precoDiaria, precoSeguro, disponivel);
		this.tipo = tipo;
	}

	public Carro() {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public double calcularConsumo() {
		return 12;
	}

	@Override
	public void imprimeInfos() {
		super.imprimeInfos();
		System.out.println("Imprimindo infos adicionais de um carro: ");
		System.out.println("Tipo: " + getTipo());
	}
	
}
