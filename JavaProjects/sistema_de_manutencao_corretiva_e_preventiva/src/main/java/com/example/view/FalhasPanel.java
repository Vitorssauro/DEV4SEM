package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.controllers.FalhaController;
import com.example.models.Falha;

public class FalhasPanel extends JPanel {
    // ATRIBUTOS
    private FalhaController falhaController;
    private JTable falhasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarFalha;

    // Construtor
    public FalhasPanel() {
        super(new BorderLayout());
        falhaController = new FalhaController();

        tableModel = new DefaultTableModel(new Object[] {
                "ID", "ID Maquina", "Data", "Problema", "Prioridade", "Operador"
        }, 0);
        falhasTable = new JTable(tableModel);

        // criar a tabela
        List<Falha> falhas = falhaController.readFalhas();
        for (Falha falha : falhas) {
            tableModel.addRow(new Object[] {
                    falha.getId(),
                    falha.getMaquinaID(),
                    falha.getData(),
                    falha.getProblema(),
                    falha.getPrioridade(),
                    falha.getOperador()
            });
        }
        JScrollPane scrollPane = new JScrollPane(falhasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        // adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // Criar as ActionListener para Botões
        btnCadastrarFalha.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // criar o método de Cadastrar
                // pegar as informações em um formulário
                // gravar o objeto de Falhas
                // chamar p controller
            }

        });
        // metodo para atualizar info
        btnSalvarAlteracoes.addActionListener(e -> {

        });

    }
}