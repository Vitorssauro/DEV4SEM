package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExemplo {
    private String[] nomes;//fixo com 3 elementos
    private List<String> nomesList;// dinâmico

    public ArraysAsListExemplo() {
        nomes = new String[]{"Maria","João","Pedro"};
        nomesList = new ArrayList<>(Arrays.asList(nomes));
    }

    //alteração da array fixo
    public void adicionarArray(String nome){
        try {
            int posicao = nomes.length;
            nomes[posicao] = nome;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            for (int i = 0; i < nomes.length; i++) {
                System.out.println(nomes[i]);
            }
        }  
    }
    //alterar uma lista
    public void adiconarList(String nome){
        try {
            nomesList.add(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println(nomesList);
        }
    }
}
