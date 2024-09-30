package com.br;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    // metodo adicionar
    public void addFuncionario() {
        //criar funcionario
        String nome = JOptionPane.showInputDialog("Digite o Nome do funcionário");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a Idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário"));
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionarios.add(funcionario);
    }

    // listar funcionario
    public void listraFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
        System.out.println(funcionario.toString());
        }
    }

    //buscar funcionario
    public void buscarFuncionario(){
        String nome = JOptionPane
        
    }

}
