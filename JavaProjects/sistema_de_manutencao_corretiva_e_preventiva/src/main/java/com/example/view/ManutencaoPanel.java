package com.example.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.example.controllers.MaquinaController;

public class ManutencaoPanel extends JPanel {
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    // Construtor
    public ManutencaoPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();
    }
}
