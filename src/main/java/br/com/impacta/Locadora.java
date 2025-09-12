package br.com.impacta;

public class Locadora {
	private BancoDeDados bancoDeDados;

	public Locadora(BancoDeDados bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}

	public Veiculo[] listarTodosVeiculos() {
		System.out.println("Listando todos os veiculos:");
		Veiculo[] todosVeiculos = bancoDeDados.buscarTodosVeiculos();
		for (Veiculo veiculo : todosVeiculos) {
			veiculo.imprimeInfos();
		}
		return todosVeiculos;
	}
	
	public Veiculo[] listarTodosVeiculos(boolean imprimeInfo) {
		System.out.println("Listando todos os veiculos:");
		Veiculo[] todosVeiculos = bancoDeDados.buscarTodosVeiculos();
		if (imprimeInfo) {
			for (Veiculo veiculo : todosVeiculos) {
				veiculo.imprimeInfos();
			}			
		}
		return todosVeiculos;
	}

	public void listarVeiculosDisponiveis() {
		System.out.println("Listando veiculos disponiveis:");
		for (Veiculo veiculo : bancoDeDados.buscarTodosVeiculos()) {
			if (veiculo.isDisponivel()) {
				veiculo.imprimeInfos();
			}
		}
	}

	public Veiculo buscarVeiculoPorModelo(String modelo) {
		for (Veiculo veiculo : bancoDeDados.buscarTodosVeiculos()) {
			if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
				return veiculo;
			}
		}
		return null;
	}

	public void alugarVeiculo(String modelo, int dias) {
		Veiculo veiculo = buscarVeiculoPorModelo(modelo);

		if (veiculo == null) {
			System.out.println("Veiculos não encontrado!");
			return;
		}

		if (!veiculo.isDisponivel()) {
			System.out.println("Veiculos não está disponível!");
			return;
		}

		double valorTotal = veiculo.calculoValorTotalAluguel(dias);
		veiculo.alugar();

		System.out.println("O valor total do aluguel sera: " + valorTotal);
		System.out.println("Veiculos " + modelo + " alugado com sucesso!");
	}

	public void devolverVeiculo(String modelo) {
		Veiculo veiculo = buscarVeiculoPorModelo(modelo);

		if (veiculo == null) {
			System.out.println("Veiculos não encontrado!");
			return;
		}

		if (veiculo.isDisponivel()) {
			System.out.println("Este Veiculos não está alugado!");
			return;
		}

		veiculo.devolver();
		System.out.println("O Veiculo " + modelo + " foi devolvido com sucesso");
	}

	public void listarVeiculosParaDevolucao() {
		System.out.println("Os veiculos disponiveis para devolucao sao:");
		for (Veiculo veiculo : bancoDeDados.buscarTodosVeiculos()) {
			if (!veiculo.isDisponivel()) {
				veiculo.imprimeInfos();
			}
		}
	}

	public void buscarVeiculosPorTipo(String tipo) {
		System.out.println("Veiculos do tipo: " + tipo);
		for (Veiculo veiculo : bancoDeDados.buscarTodosVeiculos()) {
			if (veiculo instanceof Carro carro && carro.getTipo().equalsIgnoreCase(tipo)) {
				carro.imprimeInfos();
			}
		}
	}

	public void imprimeMenuLocadora() {
		System.out.println("=".repeat(10));
		System.out.println(
				"Digite a opcao desejada\n 1 - listar veiculos \n 2 - listar veiculos disponiveis \n 3 - Alugar um veiculo \n 4 - Devolver o veiculo \n 5 - Buscar veiculos por tipo \n 6 - Fazer um Test Drive \n 7 - Trocar banco de dados \n 8 - Falar via chat \n 9 - Para sair \n ");
		System.out.println("=".repeat(10));
	}

	public void realizarTestDrive(String modelo) {
		Veiculo veiculo = buscarVeiculoPorModelo(modelo);

		if (veiculo == null) {
			System.out.println("Veículo não encontrado!");
			return;
		}

		if (!veiculo.isDisponivel()) {
			System.out.println("Veículo não está disponível para test drive!");
			return;
		}

		System.out.println("\n INICIANDO TEST DRIVE DO " + modelo.toUpperCase());
		System.out.println("=".repeat(40));

		veiculo.ligar();

		System.out.println("Consumo médio: " + veiculo.calcularConsumo() + " km/l");

		if (veiculo instanceof Carro) {
			System.out.println("Acelerando um carro");
		} else if (veiculo instanceof Moto) {
			System.out.println("Acelerando uma moto");
		}

		veiculo.desligar();
		System.out.println("Test drive finalizado!");
		System.out.println("=".repeat(40));
	}
	
	public void trocarBancoDeDados(BancoDeDados novoBanco) {
        this.bancoDeDados = novoBanco;
        System.out.println("Banco de dados alterado para: " + novoBanco.getNomeBanco());
    }
}
