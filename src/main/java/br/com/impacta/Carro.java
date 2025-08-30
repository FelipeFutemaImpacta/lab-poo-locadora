package br.com.impacta;

public class Carro {

	private String modelo;
	private String marca;
	private double precoDiaria;
	private double precoSeguro;
	private boolean disponivel;
	private String tipo;
	
	public Carro(String modelo, String marca, double precoDiaria, double precoSeguro, boolean disponivel, String tipo) {
		this.modelo = modelo;
		this.marca = marca;
		this.precoDiaria = precoDiaria;
		this.precoSeguro = precoSeguro;
		this.disponivel = disponivel;
		this.tipo = tipo;
		
	}
	
	public Carro() {
		
	}
	
	public double getPrecoDiaria() {
		return this.precoDiaria;
	}
	
	public void setPrecoDiaria(double precoDiaria) {
		if (precoDiaria > 0) {
			this.precoDiaria = precoDiaria;			
		} else {
			System.out.println("O Preco da diaria deve ser maior que zero !");
		}
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

	public double getPrecoSeguro() {
		return precoSeguro;
	}

	public void setPrecoSeguro(double precoSeguro) {
		this.precoSeguro = precoSeguro;
	}

	public boolean isDisponivel() {
		return disponivel;
	}
	
	public String isDisponivelFormatado() {
		return disponivel ? "Disponivel" : "Indisponivel";
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void imprimeInfos() {
		System.out.println("=".repeat(10));
        System.out.println("Modelo do Carro: " + this.getModelo());
        System.out.println("Marca do Carro: " + this.getMarca());
        System.out.println("preco da diaria do Carro: " + this.getPrecoDiaria());
        System.out.println("Tipo do Carro: " + this.getTipo());
        System.out.println("O carro esta " + this.isDisponivelFormatado());
        System.out.println("=".repeat(10));
	}
	
	public void alugar() {
		System.out.println("O carro " + this.getModelo() + " foi alugado com sucesso");
		this.disponivel = false;
	}
	
	public void devolver() {
		System.out.println("O carro " + this.getModelo() + " foi devolvido com sucesso");
		this.disponivel = true;
	}
	
	public double calculoValorTotalAluguel(int qtdDias) {
		double valorSeguro = this.getPrecoSeguro() * this.getPrecoDiaria();
		double valorTotal = (qtdDias * this.getPrecoDiaria()) + (qtdDias * valorSeguro);
         
		return valorTotal;
	}
	
}
