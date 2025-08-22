package br.com.impacta;

import java.util.Scanner;

public class Main {

  static String[] modelos = { "Civic", "Corolla", "HRV", "Onix", "Compass" };
  static String[] tipos = { "Sedan", "Sedan", "SUV", "Hatch", "SUV" };
  static double[] precosDiaria = { 120.0, 110.0, 150.0, 90.0, 180.0 };
  static boolean[] disponibilidade = { true, false, true, true, false };
  static String[] locatarios = { "", "João Silva", "", "", "Maria Santos" };


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== SISTEMA DE LOCADORA DE VEÍCULOS ===");
    System.out.println("Bem-vindo ao nosso sistema!");

    boolean continuar = true;

    while (continuar) {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("MENU PRINCIPAL");
		System.out.println("=".repeat(50));
		System.out.println("1. Listar todos os veículos");
		System.out.println("2. Listar veículos disponíveis");
		System.out.println("3. Alugar veículo");
		System.out.println("4. Devolver veículo");
		System.out.println("5. Buscar por tipo de veículo");
		System.out.println("0. Sair");
		System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1 -> {
			System.out.println("\n=== TODOS OS VEÍCULOS ===");
			System.out.printf("%-5s %-12s %-8s %-12s %-12s %-15s%n", "ID", "MODELO", "TIPO", "PREÇO/DIA", "STATUS",
					"LOCATÁRIO");
			System.out.println("-".repeat(70));

			for (int i = 0; i < modelos.length; i++) {
				String status = disponibilidade[i] ? "Disponível" : "Alugado";
				String locatario = locatarios[i].isEmpty() ? "-" : locatarios[i];

				System.out.printf("%-5d %-12s %-8s R$ %-9.2f %-12s %-15s%n", (i + 1), modelos[i], tipos[i],
						precosDiaria[i], status, locatario);
			}
        }
        case 2 -> {
			System.out.println("\n=== VEÍCULOS DISPONÍVEIS ===");
			System.out.printf("%-5s %-12s %-8s %-12s%n", "ID", "MODELO", "TIPO", "PREÇO/DIA");
			System.out.println("-".repeat(40));

			boolean encontrou = false;
			for (int i = 0; i < modelos.length; i++) {
				if (disponibilidade[i]) {
					System.out.printf("%-5d %-12s %-8s R$ %.2f%n", (i + 1), modelos[i], tipos[i], precosDiaria[i]);
					encontrou = true;
				}
			}

			if (!encontrou) {
				System.out.println("Nenhum veículo disponível no momento.");
			}
        }
        case 3 -> {
        	System.out.println("\n=== ALUGAR VEÍCULO ===");
        	System.out.println("\n=== VEÍCULOS DISPONÍVEIS ===");
			System.out.printf("%-5s %-12s %-8s %-12s%n", "ID", "MODELO", "TIPO", "PREÇO/DIA");
			System.out.println("-".repeat(40));

			boolean encontrou = false;
			for (int i = 0; i < modelos.length; i++) {
				if (disponibilidade[i]) {
					System.out.printf("%-5d %-12s %-8s R$ %.2f%n", (i + 1), modelos[i], tipos[i], precosDiaria[i]);
					encontrou = true;
				}
			}

			if (!encontrou) {
				System.out.println("Nenhum veículo disponível no momento.");
			}

            System.out.print("Digite o ID do veículo que deseja alugar: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            // Validar ID
            if (id < 1 || id > modelos.length) {
              System.out.println("ID inválido!");
              return;
            }

            int index = id - 1;

            // Verificar disponibilidade
            if (!disponibilidade[index]) {
              System.out.println("Veículo não está disponível!");
              return;
            }

            System.out.print("Digite o nome do locatário: ");
            String nomeLocatario = scanner.nextLine();

            System.out.print("Digite a quantidade de dias: ");
            int dias = scanner.nextInt();

            // Processar aluguel
            disponibilidade[index] = false;
            locatarios[index] = nomeLocatario;

            double valorTotal = precosDiaria[index] * dias;

            System.out.println("\n=== CONFIRMAÇÃO DO ALUGUEL ===");
            System.out.println("Veículo: " + modelos[index] + " (" + tipos[index] + ")");
            System.out.println("Locatário: " + nomeLocatario);
            System.out.println("Período: " + dias + " dias");
            System.out.println("Valor total: R$ " + String.format("%.2f", valorTotal));
            System.out.println("Aluguel realizado com sucesso!");
        }
        case 4 -> {
        	System.out.println("\n=== DEVOLVER VEÍCULO ===");

            // Listar veículos alugados
            System.out.printf("%-5s %-12s %-15s%n", "ID", "MODELO", "LOCATÁRIO");
            System.out.println("-".repeat(35));

            boolean encontrou = false;
            for (int i = 0; i < modelos.length; i++) {
              if (!disponibilidade[i]) {
                System.out.printf("%-5d %-12s %-15s%n",
                    (i + 1), modelos[i], locatarios[i]);
                encontrou = true;
              }
            }

            if (!encontrou) {
              System.out.println("Nenhum veículo está alugado no momento.");
              return;
            }

            System.out.print("Digite o ID do veículo para devolver: ");
            int id = scanner.nextInt();

            if (id < 1 || id > modelos.length) {
              System.out.println("ID inválido!");
              return;
            }

            int index = id - 1;

            if (disponibilidade[index]) {
              System.out.println("Este veículo não está alugado!");
              return;
            }

            // Processar devolução
            disponibilidade[index] = true;
            locatarios[index] = "";

            System.out.println("Veículo " + modelos[index] + " devolvido com sucesso!");
        }
        case 5 -> {
        	System.out.println("\n=== BUSCAR POR TIPO ===");
            System.out.println("Tipos disponíveis: Sedan, SUV, Hatch");
            System.out.print("Digite o tipo desejado: ");
            String tipoBusca = scanner.nextLine();

            System.out.println("\nResultados para tipo: " + tipoBusca);
            System.out.printf("%-5s %-12s %-12s %-12s%n", "ID", "MODELO", "PREÇO/DIA", "STATUS");
            System.out.println("-".repeat(45));

            boolean encontrou = false;
            for (int i = 0; i < modelos.length; i++) {
              if (tipos[i].equalsIgnoreCase(tipoBusca)) {
                String status = disponibilidade[i] ? "Disponível" : "Alugado";
                System.out.printf("%-5d %-12s R$ %-9.2f %-12s%n",
                    (i + 1), modelos[i], precosDiaria[i], status);
                encontrou = true;
              }
            }

            if (!encontrou) {
              System.out.println("Nenhum veículo encontrado para este tipo.");
            }
        }
        case 0 -> {
          continuar = false;
          System.out.println("Obrigado por usar nosso sistema!");
        }
        default -> {
          System.out.println("Opção inválida!");
        }
      }

      if (continuar) {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
      }
    }

    scanner.close();
  }
}