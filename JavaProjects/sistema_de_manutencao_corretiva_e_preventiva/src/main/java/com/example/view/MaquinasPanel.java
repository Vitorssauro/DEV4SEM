package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List; // Import correto para List

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    // Construtor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        // Criar Tabela
        List<Maquina> maquinas = maquinaController.readMaquinas();
        tableModel = new DefaultTableModel(new Object[] {
            "ID", "Nome", "Fabricante", "Detalhes", "Localização", "Tempo de Vida Estimado"
        }, 0); // Inicializando o tableModel

        maquinasTable = new JTable(tableModel); // Inicializando a tabela

        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getNome(),
                maquina.getFabricante(),
                maquina.getModelo(),
                maquina.getDetalhes(),
                maquina.getLocalizacao(),
                maquina.getTempoVidaEstimado()
            });
        }
        
        JScrollPane scrollPane = new JScrollPane(maquinasTable); // Adicionando a tabela ao JScrollPane
        this.add(scrollPane, BorderLayout.CENTER);

        // Adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH); // Corrigindo o nome do painel

        // Criar as ActionsListener para os Botões
    }
}
