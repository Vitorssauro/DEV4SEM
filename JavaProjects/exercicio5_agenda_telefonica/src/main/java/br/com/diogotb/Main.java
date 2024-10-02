package br.com.diogotb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoController agenda = new ContatoController(5);
        int operacao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n-----Agenda de Contatos-----");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Buscar Contato pelo Nome");
            System.out.println("4 - Deletar Contato pelo Nome");
            System.out.println("5 - Sair...");
            try {
                operacao = sc.nextInt();
                switch (operacao) {
                    case 1:
                        try {
                            System.out.println("Nome:");
                            String nome = sc.next();
                            System.out.println("Endereço:");
                            String endereco = sc.nextLine();
                            System.out.println("Email:");
                            String email = sc.next();
                            System.out.println("Telefone:");
                            String telefone = sc.next();
                            Contato contato = new Contato(nome, email, endereco, telefone);
                            agenda.addContato(contato);
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 2:
                        agenda.listarContato();
                        break;
                    case 3:
                        try {
                            System.out.println("Digite o Nome a Ser Buscado:");
                            String nomeBusca = sc.next();
                            System.out.println(agenda.buscarContato(nomeBusca).toString());
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("Digite o Nome a Ser Buscado:");
                            String nomeDeletar = sc.next();
                            agenda.removerContato(nomeDeletar);
                            System.out.println("Contato Deletado Com Sucesso");
                        } catch (Exception e) {
                            System.err.println(e);
                        }
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Digite um nº Válido");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e);
                System.out.println("Digite uma Valor válido");
                operacao = 2;
            }

        } while (operacao != 5);
        sc.close();
    }
}