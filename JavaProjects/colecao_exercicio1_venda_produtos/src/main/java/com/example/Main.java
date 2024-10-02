package com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        GerencimentoVendas gv = new GerencimentoVendas();
        String operacao;
        do {
            operacao = JOptionPane.showInputDialog(
                    "\n----Gerenciamento de Vendas----\n"
                            + "1 - Registra Venda \n"
                            + "2 - Listar Vendas do Cliente \n"
                            + "3 - Listar Vendas Valor Mínimo \n"
                            + "4 - Sair");

            switch (operacao) {
                case "1":
                    String cpf = JOptionPane.showInputDialog("Informe CPF do Cliente");
                    String nomeProduto = JOptionPane.showInputDialog("Informe Nome PRoduto");
                    double valorProduto = Double.parseDouble(JOptionPane.showInputDialog(
                            "Informe o valor do produto"));
                    Produto produto = new Produto(nomeProduto, valorProduto);
                    gv.venda(cpf, produto);
                    break;
                case "2":
                    String cpf2 = JOptionPane.showInputDialog("Informe CPF do Cliente");
                    gv.produtosCliente(cpf2);
                    break;
                case "3":
                    String cpf3 = JOptionPane.showInputDialog("Informe CPF do Cliente");
                    double valorMinimoProduto = Double.parseDouble(JOptionPane.showInputDialog(
                            "Informe o valor Mínimo de venda por produto"))
                    gv.produtosClienteAcimaDe(cpf3, valorMinimoProduto);
                    break;
                case "4":
                    System.out.println("sair");
                default:
                    break;
            }

        } while (operacao != "4");
    }
}