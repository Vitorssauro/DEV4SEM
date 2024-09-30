package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Curso {
    // atributos
    private String nomeCurso;
    private List<Aluno> alunos;
    private Professor professor;

    // construtor
    public Curso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
        alunos = new ArrayList<>();
    }

    // metodo adicionar professor
    public void addProf(Professor professor) {
        this.professor = professor;

    }

    // metodo adicionar aluno
    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // metodo infoCruso
    public void infoCruso() {
        System.out.println("Curso: " + nomeCurso);
        System.out.println("Professor: " + professor.getNome());
        System.out.println("Alunos Matriculados");
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome() + "RA: " + aluno.getMatricula());
        }
    }

    // metodo lançar as nota
    public void atribuirNota() {
        if (alunos.size() == 0) {
            System.out.println("Nenhum aluno cadastrado");
        } else {
            for (Aluno aluno : alunos) { // percorrer arrayList
                double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota do " + aluno.getNome()) + ": ");
                aluno.setNota(nota);
            }
        }
    }

    // metodo exibir resultado final
    public void exibirResultadoFinal() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirInfo());
            System.out.println(aluno.avaliarDesempenho());
        }
    }

}
