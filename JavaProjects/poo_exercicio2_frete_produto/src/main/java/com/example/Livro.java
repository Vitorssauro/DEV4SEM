package com.example;

public class Livro extends Produto implements Transportavel {
    // atributo
    private double volume;

    public Livro(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
    }

    @Override
    public double calcularPeso() {
        double peso = volume*1;
        return peso;
    }

    @Override
    public double calcularFrete(){
        double frete = calcularPeso()*0.5;
        return frete;
    }
}
