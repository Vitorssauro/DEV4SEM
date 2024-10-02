package com.example;

import java.util.ArrayList;
import java.util.List;

public class ListExemplo {
    private List<String> nomes;

    public ListExemplo() {
        nomes = new ArrayList<>();
    }
    //add
    public void adiconarNome(String nome){
        nomes.add(nome);
        System.out.println(nomes.indexOf(nome));
    }
    //list
    public void listarNomes(){
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }
    //remove
    public void deleteNome(String nome){
        nomes.remove(nome);
        System.out.println("Nome Removido com sucesso");
    }
    //update
    public void modificarNomeIndex(int index, String nome){
        String nomeAnterior = nomes.get(index);
        nomes.set(index,nome);
        System.out.println(
            "Nome da posição "+index+", "+nomeAnterior+", alterado para "+nome);
    }
}
