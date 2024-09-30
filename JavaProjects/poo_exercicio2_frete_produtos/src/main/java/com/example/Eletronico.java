package com.example;

public class Eletronico extends Produto {
    // Atributos
    private double peso;

    // Construtores
    public Eletronico(String nome, double preco, double peso) {
        super(nome, preco);
        this.peso = peso;
    }

}
