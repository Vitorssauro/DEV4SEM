package com.br;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Funcionario {
    // atributos
    private String nome;
    private int idade;
    private double salario;

    // toString
    public String toString() {
        return "Nome: ," + nome + "Idade: ," + idade + "Salario: " + salario;
    }

}
