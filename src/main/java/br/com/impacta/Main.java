package br.com.impacta;

import java.util.Scanner;

public class Main {

  //variaveis como se fosse banco de dados
  static String[] modelosDosCarros = {"hb20", "gol", "uno", "fiesta", "ka", "toro"};
  static String[] marcasDosCarros = {"hyundai", "volkswagen", "fiat", "ford", "ford", "fiat"};
  static double[] precosDiariasDosCarros = {50, 60, 70, 80, 90, 120};
  static double[] precosSeguroDosCarros = {0.3, 0.4, 0.5, 0.6, 0.7, 0.8};
  static boolean[] disponibilidadeDosCarros = {true, true, false, false, true, true};
  static String[] tiposDeCarro = {"hatch", "hatch", "hatch", "hatch", "hatch", "caminhonete"};
  
  public static void main(String[] args) {  
	  //Implemente seu codigo aqui
    //System.out.println("Ola Mundo !!!!");

    int numero = 10;
    double preco = 10.50;
    boolean isAtivo = true;
    String nome = "Joao";
    String sobrenome = " Silva";
    String nomeCompleto = nome.concat(sobrenome);

    //String[] clientes = {"Joao", "Maria", "Jose"};
    //System.out.println(clientes[0]);
    //System.out.println(clientes[1]);
    //System.out.println(clientes[2]);
    //System.out.println(nomeCompleto);

    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.println("=".repeat(10));
      System.out.println("Digite a opcao desejada\n 1 - listar veiculos \n 2 - listar veiculos disponiveis \n 3 - Alugar um veiculo \n 4 - Devolver o veiculo \n 5 - Buscar veiculos por tipo \n 9 - Para sair \n ");
      System.out.println("=".repeat(10));
      int opcao = scanner.nextInt();
      
      if (opcao == 9) {
        System.out.println("Finalizando o programa...");
        break;
      }

      switch(opcao) {
        case 1 -> {
          System.out.println("o usuario gostaria de listar todos os veiculos");
          for (int indice = 0; indice < modelosDosCarros.length; indice++) {
            System.out.println("=".repeat(10));
            System.out.println("Modelo do Carro: " + modelosDosCarros[indice]);
            System.out.println("Marca do Carro: " + marcasDosCarros[indice]);
            System.out.println("preco da diaria do Carro: " + precosDiariasDosCarros[indice]);
            System.out.println("Tipo do Carro: " + tiposDeCarro[indice]);
            if (disponibilidadeDosCarros[indice] == true) {
              System.out.println("O carro esta disponivel");
            } else {
              System.out.println("O carro esta indisponivel");
            }
            System.out.println("=".repeat(10));
          }

        }
        case 2 -> {
          System.out.println("o usuario gostaria de listar os veiculos disponiveis");
          for (int indice = 0; indice < modelosDosCarros.length; indice++) {
            if (disponibilidadeDosCarros[indice] == true) {
              System.out.println("=".repeat(10));
              System.out.println("Modelo do Carro: " + modelosDosCarros[indice]);
              System.out.println("Marca do Carro: " + marcasDosCarros[indice]);
              System.out.println("preco da diaria do Carro: " + precosDiariasDosCarros[indice]);
              System.out.println("Tipo do Carro: " + tiposDeCarro[indice]);
              System.out.println("O carro esta disponivel");
              System.out.println("=".repeat(10));
            }
          }
        }
        case 3 -> {
          System.out.println("O usuario gostaria de alugar um veiculo");

          System.out.println("Os veiculos disponiveis para alugar sao: ");
          for (int indice = 0; indice < modelosDosCarros.length; indice++) {
            if (disponibilidadeDosCarros[indice] == true) {
              System.out.println("=".repeat(10));
              System.out.println("Modelo do Carro: " + modelosDosCarros[indice]);
              System.out.println("Marca do Carro: " + marcasDosCarros[indice]);
              System.out.println("preco da diaria do Carro: " + precosDiariasDosCarros[indice]);
              System.out.println("Tipo do Carro: " + tiposDeCarro[indice]);
              System.out.println("=".repeat(10));
            }
          }
          System.out.println("Digite o modelo do carro que deseja alugar: ");
          String modeloEscolhido = scanner.next();

          System.out.println("Digite quantos dias voce gostaria de alugar: ");
          int diasAluguel = scanner.nextInt();

          double valorTotal = 0;
          double valorSeguro = 0;
          for (int indice = 0; indice < modelosDosCarros.length; indice++) {
            if (modelosDosCarros[indice].equals(modeloEscolhido)) {
              valorSeguro = precosSeguroDosCarros[indice] * precosDiariasDosCarros[indice];
              valorTotal = (diasAluguel * precosDiariasDosCarros[indice]) + (diasAluguel * valorSeguro);
              disponibilidadeDosCarros[indice] = false;
            }
          }
          
          System.out.println("O valor total do aluguel sera: " + valorTotal);
          
        }
        case 4 -> {
          System.out.println("o usuario gostaria de devolver um veiculo");

          System.out.println("Os veiculos disponiveis para devolucao sao: ");
          for (int indice = 0; indice < modelosDosCarros.length; indice++) {
            if (disponibilidadeDosCarros[indice] == false) {
              System.out.println("=".repeat(10));
              System.out.println("Modelo do Carro: " + modelosDosCarros[indice]);
              System.out.println("Marca do Carro: " + marcasDosCarros[indice]);
              System.out.println("Tipo do Carro: " + tiposDeCarro[indice]);
              System.out.println("=".repeat(10));
            }
          }

          System.out.println("Qual veiculo voce gostaria de devolver, digite o modelo: ");
          String modeloDevolucao = scanner.next();

          for (int indice = 0; indice < modelosDosCarros.length; indice++) {
            if (modelosDosCarros[indice].equals(modeloDevolucao)) {
              System.out.println("O carro " + modeloDevolucao + " foi devolvido com sucesso");
              disponibilidadeDosCarros[indice] = true;
            }
          }
        }
        case 5 -> {
          System.out.println("o usuario gostaria de listar os veiculos por tipo");
          System.out.println("Por favor, digite. tipo de carro a ser buscado: ");
          String tipoCarroEscolhido = scanner.next();

          System.out.println("O tipo escolhido foi: " + tipoCarroEscolhido);

          for (int indice = 0; indice < modelosDosCarros.length; indice++) {
            if (tiposDeCarro[indice].equals(tipoCarroEscolhido)) {
              System.out.println("=".repeat(10));
              System.out.println("Modelo do Carro: " + modelosDosCarros[indice]);
              System.out.println("Marca do Carro: " + marcasDosCarros[indice]);
              System.out.println("preco da diaria do Carro: " + precosDiariasDosCarros[indice]);
              System.out.println("Tipo do Carro: " + tiposDeCarro[indice]);
              if (disponibilidadeDosCarros[indice] == true) {
                System.out.println("O carro esta disponivel");
              } else {
                System.out.println("O carro esta indisponivel");
              }
              System.out.println("=".repeat(10));
            }
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