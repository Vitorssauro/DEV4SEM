package com.example;

public class Main {
    public static void main(String[] args) {
        LeituraNotasAlunos obj = new LeituraNotasAlunos();
        obj.leituraFile();
        obj.alunoMaiorNota();
        obj.alunoMenorNota();
        obj.mediaTurma();
    }
}