package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        String operacao = "0";
        do {
            operacao = JOptionPane.showInputDialog(
                    "\n --- Gerenciamneto de Curso --- \n"
                            + "1 - Criar Curso \n"
                            + "2 - Adicionar Professor \n"
                            + "3 - Adicionar Aluno \n"
                            + "4 - Informações do Curso \n"
                            + "5 - Atribuir Nota \n"
                            + "6 - Resultado Final \n"
                            + "7 - Sair");
            switch (operacao) {
                case "1":
                    String nomeCurso = JOptionPane.showInputDialog("Informe o Nome do Curso");
                    cursos.add(new Curso(nomeCurso));
                    break;

                case "2":
                    String nomeCursoP = JOptionPane.showInputDialog("Informer o nome do Curso");
                    for (Curso curso : cursos) {
                        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoP)) {
                            String nomeProf = JOptionPane.showInputDialog("Nome: ");
                            String cpfProf = JOptionPane.showInputDialog("CPF: ");
                            double salarioProf = Double.parseDouble(
                                    JOptionPane.showInputDialog("Salário: "));
                            Professor professor = new Professor(nomeProf, cpfProf, salarioProf);
                            curso.addProf(professor);
                        }
                    }
                    break;
                case "3":
                    String nomeCursoA = JOptionPane.showInputDialog("Infrome o Nome do Curso");
                    try {
                        boolean encontrado = false;
                        for (Curso curso : cursos) {
                            encontrado = true;
                            boolean novoAluno = true;
                            do {
                                String nomeAluno = JOptionPane.showInputDialog("Nome: ");
                                String cpfAluno = JOptionPane.showInputDialog("CPF: ");
                                String matriculaAluno = JOptionPane.showInputDialog("Matrícula: ");
                                curso.addAluno(new Aluno(nomeAluno, cpfAluno, matriculaAluno));
                                novoAluno = JOptionPane.showInputDialog("Inserir novo aluno?\n"
                                        + "1 - Sim\n"
                                        + "2 - Não\n").equals("1") ? true : false;
                            } while (novoAluno);
                        }
                        if (!encontrado) {
                            throw new Exception("Curso não encontrado");
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "4":
                    String nomeCursoI = JOptionPane.showInputDialog("Informe o Nome do Curso");
                    for (Curso curso : cursos) {
                        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoI)) {
                            curso.infoCruso();
                        }
                    }
                    break;
                case "5":
                    String nomeCursoN = JOptionPane.showInputDialog("Informe o nome do Curso");
                    try {
                        boolean encontrado2 = false;
                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoN)) {
                                curso.atribuirNota();
                                encontrado2 = true;
                            }
                        }
                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                case "6":
                    String nomeCursoR = JOptionPane.showInputDialog("Informe o Nome do Curso");
                    try {
                        boolean encontrado3 = false;
                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoR)) {
                                curso.exibirResultadoFinal();
                                encontrado3 = true;
                            }
                        }
                        if (!encontrado3) {
                            throw new Exception("Curso não encontrado");
                        }

                    } catch (Exception e) {
                        System.err.println(e);
                    }
                    break;
                default:
                    break;
            }
        } while (operacao != "7");
    }
}