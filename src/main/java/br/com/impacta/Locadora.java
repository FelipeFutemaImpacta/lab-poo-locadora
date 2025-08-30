package br.com.impacta;

public class Locadora {

	private Carro[] carros = new Carro[6];
	
	public Locadora() {
		Carro hb20 = new Carro("hb20", "hyundai", 50, 0.3, true, "hatch");
		Carro gol = new Carro("gol", "volkswagen", 60, 0.4, true, "hatch");
		Carro uno = new Carro("uno", "fiat", 70, 0.5, true, "hatch");
		Carro fiesta = new Carro("fiesta", "ford", 80, 0.6, true, "hatch");
		Carro ka = new Carro("ka", "ford", 90, 0.7, true, "hatch");
		Carro toro = new Carro("toro", "fiat", 120, 0.8, true, "caminhonete");
		
		carros[0] = hb20;
		carros[1] = gol;
		carros[2] = uno;
		carros[3] = fiesta;
		carros[4] = ka;
		carros[5] = toro;
	}
	
	public Carro[] getCarros() {
		return this.carros;
	}
	
	public void listarTodosVeiculos() {
        System.out.println("Listando todos os veiculos:");
        for (Carro carro : carros) {
            carro.imprimeInfos();
        }
    }
	
	public void listarVeiculosDisponiveis() {
        System.out.println("Listando veiculos disponiveis:");
        for (Carro carro : carros) {
            if (carro.isDisponivel()) {
                carro.imprimeInfos();
            }
        }
    }
	
	public Carro buscarCarroPorModelo(String modelo) {
        for (Carro carro : carros) {
            if (carro.getModelo().equalsIgnoreCase(modelo)) {
                return carro;
            }
        }
        return null;
    }
	
	public void alugarVeiculo(String modelo, int dias) {
        Carro carro = buscarCarroPorModelo(modelo);
        
        if (carro == null) {
            System.out.println("Carro não encontrado!");
            return;
        }
        
        if (!carro.isDisponivel()) {
            System.out.println("Carro não está disponível!");
            return;
        }
        
        double valorTotal = carro.calculoValorTotalAluguel(dias);
        carro.alugar();
        
        System.out.println("O valor total do aluguel sera: " + valorTotal);
        System.out.println("Carro " + modelo + " alugado com sucesso!");
    }
	
    public void devolverVeiculo(String modelo) {
        Carro carro = buscarCarroPorModelo(modelo);
        
        if (carro == null) {
            System.out.println("Carro não encontrado!");
            return;
        }
        
        if (carro.isDisponivel()) {
            System.out.println("Este carro não está alugado!");
            return;
        }
        
        carro.devolver();
        System.out.println("O carro " + modelo + " foi devolvido com sucesso");
    }
    
    public void listarVeiculosParaDevolucao() {
        System.out.println("Os veiculos disponiveis para devolucao sao:");
        for (Carro carro : carros) {
            if (!carro.isDisponivel()) {
                carro.imprimeInfos();
            }
        }
    }
    
    public void buscarVeiculosPorTipo(String tipo) {
        System.out.println("Veiculos do tipo: " + tipo);
        for (Carro carro : carros) {
            if (carro.getTipo().equalsIgnoreCase(tipo)) {
                carro.imprimeInfos();
            }
        }
    }
    
    public void imprimeMenuLocadora() {
    	 System.out.println("=".repeat(10));
         System.out.println("Digite a opcao desejada\n 1 - listar veiculos \n 2 - listar veiculos disponiveis \n 3 - Alugar um veiculo \n 4 - Devolver o veiculo \n 5 - Buscar veiculos por tipo \n 9 - Para sair \n ");
         System.out.println("=".repeat(10));
    }
	
}
