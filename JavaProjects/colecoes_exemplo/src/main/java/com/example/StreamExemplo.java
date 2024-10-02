package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExemplo {
    List<String> words = Arrays.asList(
            "banana", 
            "abacaxi", 
            "laranja", 
            "ameixa", 
            "uva", 
            "amora");

    // Crie uma nova List Resultado,
    // filtre as words que comecem com a letra "a"
    // to upperCase
    // crie um método
    public void resultadoStream() {
        List<String> resultado = words.stream()
                .filter(word -> word.startsWith("a"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        //resultado
        System.out.println(resultado);
    }

}
