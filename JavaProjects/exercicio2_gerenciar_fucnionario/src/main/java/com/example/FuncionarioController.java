package com.example;

import java.util.List;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    //médoto add
    public void addFuncionario(){
        //Criar o Funcionário
        String nome = JOptionPane.showInputDialog(
            "Digite o Nome do Funcionario");
        int idade = Integer.parseInt(JOptionPane.showInputDialog(
            "Digite Idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog(
            "Digite o Salário"));
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionarios.add(funcionario);
    } 
    //métodos listar todos os funcionário
    public void listarFuncionarios(){
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }
    //busca funcionário pelo nome
    public void buscarFuncionario(){
        String nome = JOptionPane.showInputDialog(
            "Digite o Nome do Funcionario a ser Buscado");
        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    System.out.println(funcionario.toString());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionário não Encontrado");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    // remover funcionário
    public void removerFuncionario(){
        String nome = JOptionPane.showInputDialog(
            "Digite o Nome do Funcionario a removido");
        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    funcionarios.remove(funcionario);
                    encontrado = true;
                    System.out.println("Funcionário Removido");
                    break;
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionário não Encontrado");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    //calculo de média salarial
    public void calculoMediaSalario(){
        double mediaSalarios = 0;
        if (funcionarios.size()==0) {
            System.out.println("Lista Vazia");
        }else{
            for (Funcionario funcionario : funcionarios) {
                mediaSalarios += funcionario.getSalario();
            }
            mediaSalarios/=funcionarios.size();
            System.out.println("A média de Salários é "+mediaSalarios);
        }
    }
}
