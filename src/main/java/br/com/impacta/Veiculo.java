package br.com.impacta;

public abstract class Veiculo {
	protected String modelo;
	protected String marca;
	protected double precoDiaria;
	protected double precoSeguro;
	protected boolean disponivel;

	public Veiculo(String modelo, String marca, double precoDiaria, double precoSeguro, boolean disponivel) {
		this.modelo = modelo;
		this.marca = marca;
		this.precoDiaria = precoDiaria;
		this.precoSeguro = precoSeguro;
		this.disponivel = disponivel;
	}

	public Veiculo() {
	}

	public abstract double calcularConsumo();

	public void ligar() {
		System.out.println("Ligando o veículo " + modelo + "...");
	}

	public void desligar() {
		System.out.println("Desligando o veículo " + modelo + ".");
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(double precoDiaria) {
		if (precoDiaria > 0) {
			this.precoDiaria = precoDiaria;
		}
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String isDisponivelFormatado() {
		return disponivel ? "Disponível" : "Indisponível";
	}

	public void imprimeInfos() {
		System.out.println("=".repeat(15));
		System.out.println("Modelo: " + this.getModelo());
		System.out.println("Marca: " + this.getMarca());
		System.out.println("Preço da diária: R$ " + this.getPrecoDiaria());
		System.out.println("Status: " + this.isDisponivelFormatado());
		System.out.println("Consumo: " + this.calcularConsumo() + " km/l");
		System.out.println("=".repeat(15));
	}

	public void alugar() {
		System.out.println("Veículo " + modelo + " foi alugado com sucesso!");
		this.disponivel = false;
	}

	public void devolver() {
		System.out.println("Veículo " + modelo + " foi devolvido com sucesso!");
		this.disponivel = true;
	}

	public double calculoValorTotalAluguel(int qtdDias) {
		double valorSeguro = this.precoSeguro * this.precoDiaria;
		return (qtdDias * this.precoDiaria) + (qtdDias * valorSeguro);
	}
}