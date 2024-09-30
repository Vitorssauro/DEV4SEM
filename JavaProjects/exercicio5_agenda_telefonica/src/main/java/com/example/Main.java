package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoController agenda = new ContatoController(5);
        int operacao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n------------ Agenda de Contatos ------------");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Buscar Contato pelo Nome");
            System.out.println("4 - Sair");
            try {
                operacao = sc.nextInt();
                switch (operacao) {
                    case 1:
                        System.out.println("Nome:");
                        String nome = sc.next();
                        System.out.println("Endereço:");
                        String endereco = sc.next();
                        System.out.println("E-mail:");
                        String email = sc.next();
                        System.out.println("Telefone:");
                        String telefone = sc.next();
                        Contato contato = new Contato(nome, email, endereco, telefone);
                        agenda.addContato(contato);
                        break;
                    case 2:
                        agenda.listarContato();
                        break;
                    case 3:
                        try {
                            System.out.println("Digite o nome a ser buscado");
                            String nomeBuscado = sc.next();
                            agenda.buscarContato(nomeBuscado);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Digite um Nº Válido");
                        break;

                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (operacao != 4);
        sc.close();
    }
}