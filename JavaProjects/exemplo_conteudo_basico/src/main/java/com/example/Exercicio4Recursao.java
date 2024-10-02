package com.example;

import java.util.Scanner;

public class Exercicio4Recursao {
    //atributos
    int numero = -1; 

    Scanner sc = new Scanner(System.in);

    //métodos
    //calcular o fatorial!!!! - recursão
    public long fatorial (int numero){
        if (numero==0 || numero ==1) {
            return 1;
        }else{
            return numero*fatorial(numero-1);
            // 5! = 5*4!
            // 4! = 4*3!
            // 3! = 3*2!
        }
    }

    // fazer operação 
    public void calculadora() throws Exception{
        while (true) {
            System.out.println("Digite um nº");
            numero = sc.nextInt();
            if (numero<0){
                throw new Exception("Não é Permitido nº Negativo");
            }
            try {
                long resultado = fatorial(numero);
                System.out.println("O fatorial é "+resultado);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
