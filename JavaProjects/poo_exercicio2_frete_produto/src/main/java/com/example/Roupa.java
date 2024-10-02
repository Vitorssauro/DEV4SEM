package com.example;

public class Roupa extends Produto implements Transportavel {
    // atributo
    private double volume;

    public Roupa(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    @Override
    public double calcularPeso() {
        double peso = volume * 0.5;
        return peso;
    }

    @Override
    public double calcularFrete() {
        double frete = calcularPeso() * 3;
        return frete;
    }
}
