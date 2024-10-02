package com.example;

import java.util.Scanner;

public class Exercicio1 {

    //atributos
    double[] notas = new double[4];
    double media = 0;
    boolean bonus = false;

    //métodos
    public void calculoMedia(){
        Scanner sc = new Scanner(System.in);
        //receber as notas
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Digite a Nota "+(i+1)+":");
            notas[i]=sc.nextDouble();
            media+=notas[i]; // acumula o valor das notas em 
        }
        //calcular a média
        media = media/notas.length;
        
        //verificar bonus
        if (notas[0]>=9 && notas[1]>=9 && notas[2]>=9 && notas[3]>=9) {
            media = (media*1.1>10?media=10:media*1.1);//operador Ternário
            bonus = true;
            //se média for maior que 10
        }
        if (bonus) {
            System.out.println("Aluno contemplado com Bónus de 10%");
        }

        //printar Resultado
        if (media>=7) {
            System.out.println("A média do Aluno é %.2f"+media +" resultado Aprovado");
        } else if(media>=5 && media<7){
            System.out.println("A média do Aluno é "+media +" resultado Recuperação");
        } else{
            System.out.println("A média do Aluno é %.2f"+media +" resultado Reprovado");
        }
        sc.close();
    }
    
}
