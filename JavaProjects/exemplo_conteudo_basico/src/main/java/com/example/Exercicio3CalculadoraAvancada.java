package com.example;

import java.util.Scanner;

public class Exercicio3CalculadoraAvancada {
    // atributos
    double valor1 = 0;
    double valor2 = 0;
    double resultado = 0;
    int escolha = 0;

    Scanner sc = new Scanner(System.in);

    public double soma(double a, double b) {
        this.resultado = a + b;
        return resultado;
    }

    public double subtrair(double a, double b) {
        this.resultado = a - b;
        return resultado;
    }

    public double multiplicar(double a, double b) {
        this.resultado = a * b;
        return resultado;
    }

    public double dividir(double a, double b) {
        try {
            this.resultado = a / b;
        } catch (ArithmeticException e) {
            System.err.println("Não Dividir por Zero");
        }
        return resultado;
    }

    public double raiz(double a) throws Exception {
        if (a < 0) {
            throw new Exception(" Número deve ser maior que Zero");
        }
        try {
            this.resultado = Math.sqrt(a);

        } catch (Exception e) {
            System.err.println(e);
        }
        return resultado;
    }

    public void menu() {
        System.out.println("\n--- Calculadora Avançada ---");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Multiplicação");
        System.out.println("4. Divisão");
        System.out.println("5. Raiz Quadrada");
        System.out.println("6. Sair");
    }


    public void escolhaOperacao() {

        if (escolha >= 1 && escolha < 5) {
            System.out.println("Digite o valor 1:");
            valor1 = sc.nextDouble();
            System.out.println("Digite o valor 2:");
            valor2 = sc.nextDouble();
        } else if (escolha == 5) {
            System.out.println("Digite o valor 1:");
            valor1 = sc.nextDouble();
        } else if (escolha ==6) {
            System.out.println("Saindo....");
        } else{
            System.out.println("Digite um nº válido");
        }
    }

    // calculadora 
    public void calculadora(){
        do {
            menu();
            try {
                escolha = sc.nextInt();
                switch (escolha) {
                    case 1:
                        escolhaOperacao();
                        soma(valor1, valor2);
                        break;
                    case 2:
                        escolhaOperacao();
                        subtrair(valor1, valor2);
                        break;
                    case 3:
                        escolhaOperacao();
                        multiplicar(valor1, valor2);
                        break;
                    case 4:
                        escolhaOperacao();
                        dividir(valor1, valor2);
                        break;
                    case 5:
                        escolhaOperacao();
                        raiz(valor1);
                        break;
                    case 6:
                        escolhaOperacao();
                        break;
                    default:
                        escolhaOperacao();
                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } while (escolha!=6);
    }

}
