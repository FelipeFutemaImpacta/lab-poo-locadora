package br.com.impacta;

import java.util.List;
import java.util.Scanner;

import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	private static ChatModel chatModel;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		BancoDeDados bancoComum = new BancoDeDadosEmMemoria();
		Locadora locadora = new Locadora(bancoComum);

		Scanner scanner = new Scanner(System.in);

		while (true) {
			locadora.imprimeMenuLocadora();
			int opcao = scanner.nextInt();

			if (opcao == 9) {
				System.out.println("Finalizando o programa...");
				System.exit(1);
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
			case 8 -> {
				System.out.println("O usuario gostaria de falar via chat");
                System.out.println("Ola eu sou o atendente virtual da Locadora, como posso te ajudar ?");
                System.out.print("Digite aqui: ");
                String msg = scanner.next();
                msg += scanner.nextLine();
                
                System.out.println(msg);
                
                MessageWindowChatMemory memory = MessageWindowChatMemory.builder()
					    .maxMessages(10)
					    .build();
				
                String todosVeiculos = "\n ";
                
                for (Veiculo veiculo : locadora.listarTodosVeiculos(false)) {
                	todosVeiculos = todosVeiculos + veiculo.toString() + " \n";
                }
                
                Message systemMessage = new SystemMessage("Voce é um assistente de atendimento de uma locadora de veiculos no Brasil. Sempre seja cordial e responda em portugues do Brasil. Abaixo segue as infos de veiculos que temos: \n " + todosVeiculos);
				Message userMessage = new UserMessage(msg);

				memory.add("1", systemMessage);
				memory.add("1", userMessage);
				
				List<Message> list = memory.get("1");
				
				Prompt prompt = new Prompt(list);
				
				String response = chatModel.call(prompt).getResult().getOutput().getText();
				
				System.out.println("Resposta do atendente: ");
				System.out.println(response);
				System.out.println("========================");
			}
			default -> {
				System.out.println("opcao invalida");
			}
			}
		}

		scanner.close();

	}

	@Autowired
	public void setChatModel(ChatModel chatModel) {
		Main.chatModel = chatModel;
	}
	
	
}