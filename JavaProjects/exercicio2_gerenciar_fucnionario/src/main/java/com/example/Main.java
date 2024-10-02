package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionario = new FuncionarioController();
        int operacao = 0;
        do {
            operacao = Integer.parseInt(JOptionPane.showInputDialog(
                    "\nGerenciamento de Funcionários\n"
                    +"1-Adiconar Funcinário\n"
                    +"2-Listar Fucnionário\n"
                    +"3-Buscar Funcionário\n"
                    +"4-Remover Funcionário\n"
                    +"5-Ver Média Salarial\n"
                    +"6-Sair...\n"));
            switch (operacao) {
                case 1:
                    gerenciaFuncionario.addFuncionario();
                    break;
                case 2: 
                    gerenciaFuncionario.listarFuncionarios();
                    break;
                case 3:
                    gerenciaFuncionario.buscarFuncionario();
                    break;
                case 4:
                    gerenciaFuncionario.removerFuncionario();
                    break;
                case 5:
                    gerenciaFuncionario.calculoMediaSalario();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Insira uma opção Válida");
                    break;
            }
        } while (operacao!=6);
    }
}