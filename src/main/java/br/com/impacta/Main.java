package br.com.impacta;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BancoDeDados bancoComum = new BancoDeDadosEmMemoria();
		Locadora locadora = new Locadora(bancoComum);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			locadora.imprimeMenuLocadora();
			int opcao = scanner.nextInt();

			if (opcao == 9) {
				System.out.println("Finalizando o programa...");
				break;
			}

			switch (opcao) {
			case 1 -> {
				System.out.println("o usuario gostaria de listar todos os veiculos");
				locadora.listarTodosVeiculos();

			}
			case 2 -> {
				System.out.println("o usuario gostaria de listar os veiculos disponiveis");
				locadora.listarVeiculosDisponiveis();
			}
			case 3 -> {
				System.out.println("O usuario gostaria de alugar um veiculo");

				System.out.println("Os veiculos disponiveis para alugar sao: ");
				locadora.listarVeiculosDisponiveis();

				System.out.println("Digite o modelo do carro que deseja alugar: ");
				String modeloEscolhido = scanner.next();

				System.out.println("Digite quantos dias voce gostaria de alugar: ");
				int diasAluguel = scanner.nextInt();

				locadora.alugarVeiculo(modeloEscolhido, diasAluguel);
			}
			case 4 -> {
				System.out.println("o usuario gostaria de devolver um veiculo");

				locadora.listarVeiculosParaDevolucao();

				System.out.println("Qual veiculo voce gostaria de devolver, digite o modelo: ");
				String modeloDevolucao = scanner.next();

				locadora.devolverVeiculo(modeloDevolucao);
			}
			case 5 -> {
				System.out.println("o usuario gostaria de listar os veiculos por tipo");
				System.out.println("Por favor, digite. tipo de carro a ser buscado: ");
				String tipoCarroEscolhido = scanner.next();

				System.out.println("O tipo escolhido foi: " + tipoCarroEscolhido);

				locadora.buscarVeiculosPorTipo(tipoCarroEscolhido);

			}
			case 6 -> {
				System.out.println("\n TEST DRIVE");
				locadora.listarVeiculosDisponiveis();

				System.out.print("Digite o modelo para test drive: ");
				String modelo = scanner.next();

				locadora.realizarTestDrive(modelo);
			}
			case 7 -> {
                System.out.println("\n TROCAR BANCO DE DADOS");
                System.out.println("1 - Banco Principal");
                System.out.println("2 - Banco Premium");
                System.out.print("Escolha: ");
                int escolha = scanner.nextInt();
                
                if (escolha == 1) {
                    locadora.trocarBancoDeDados(new BancoDeDadosEmMemoria());
                } else if (escolha == 2) {
                    locadora.trocarBancoDeDados(new BancoDeDadosEmMemoriaPremium());
                }
            }
			default -> {
				System.out.println("opcao invalida");
			}
			}
		}

		scanner.close();

	}
}