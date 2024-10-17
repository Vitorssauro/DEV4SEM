package com.example.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;

import com.example.controllers.TecnicoController; // Certifique-se de que o controlador está implementado
import com.example.models.Tecnico; // Certifique-se de que a model está implementada

public class TecnicosPanel extends JPanel {
    // Atributos
    private TecnicoController tecnicoController;
    private JTable tecnicoTable;
    private NonEditableTableModel tableModel; // Use a nova classe de modelo
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarTecnico;
    private JButton btnDeletarTecnico; // Novo botão para deletar técnico

    public TecnicosPanel() {
        super(new BorderLayout());

        // Inicializando o controlador
        tecnicoController = new TecnicoController();

        // Inicializando o model da tabela com as colunas
        tableModel = new NonEditableTableModel(new Object[]{
                "ID", "Nome", "Especialidade", "Disponibilidade"
        }, 0);  // Número de linhas inicial: 0

        // Criar JTable com o model
        tecnicoTable = new JTable(tableModel);

        // Preenchendo a tabela com os técnicos do controlador
        List<Tecnico> tecnicos = tecnicoController.readTecnicos(); // Supondo que o método readTecnicos retorna uma lista de Tecnico
        for (Tecnico tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                    tecnico.getId(),
                    tecnico.getNome(),
                    tecnico.getEspecialidade(),
                    tecnico.getDisponibilidade()
            });
        }

        // Adicionando a JTable a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tecnicoTable); // Aqui adiciona a JTable ao JScrollPane
        this.add(scrollPane, BorderLayout.CENTER);

        // Criando painel inferior com botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Atualizar");
        btnDeletarTecnico = new JButton("Deletar"); // Inicializa o botão de deletar
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        painelInferior.add(btnDeletarTecnico); // Adiciona o botão de deletar ao painel
        this.add(painelInferior, BorderLayout.SOUTH);

        // Adicionando ActionListeners para os botões
        addActionListeners();

        // Adicionando MouseListener para a tabela
        tecnicoTable.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Verifica se foi um duplo clique
                    editarTecnico();
                }
            }
        });
    }

    // Classe interna para tornar a tabela não editável
    private class NonEditableTableModel extends DefaultTableModel {
        public NonEditableTableModel(Object[] columnNames, int rowCount) {
            super(columnNames, rowCount);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Nenhuma célula é editável
        }
    }

    private void addActionListeners() {
        // ActionListener para o botão "Cadastrar"
        btnCadastrarTecnico.addActionListener(e -> {
            // Cria um novo JDialog para o cadastro de técnico
            JDialog dialog = new JDialog((JDialog) null, "Cadastrar Novo Técnico", true);
            dialog.setSize(400, 300); // Dimensões do diálogo
            dialog.setLayout(new GridLayout(0, 2));

            // Adiciona campos de texto para os atributos do técnico
            JTextField txtNome = new JTextField();
            JTextField txtEspecialidade = new JTextField();
            JTextField txtDisponibilidade = new JTextField();

            // Define a altura dos campos
            txtNome.setPreferredSize(new java.awt.Dimension(150, 25));
            txtEspecialidade.setPreferredSize(new java.awt.Dimension(150, 25));
            txtDisponibilidade.setPreferredSize(new java.awt.Dimension(150, 25));

            // Adiciona rótulos e campos ao dialog
            dialog.add(new JLabel("Nome:"));
            dialog.add(txtNome);
            dialog.add(new JLabel("Especialidade:"));
            dialog.add(txtEspecialidade);
            dialog.add(new JLabel("Disponibilidade:"));
            dialog.add(txtDisponibilidade);

            // Botão para cadastrar o técnico
            JButton btnSubmit = new JButton("Cadastrar");
            btnSubmit.setPreferredSize(new java.awt.Dimension(150, 25)); // Define a altura do botão
            dialog.add(btnSubmit);

            // Quando o botão for clicado, valida e envia os dados
            btnSubmit.addActionListener(ev -> {
                try {
                    // Recupera os dados dos campos de texto
                    String nome = txtNome.getText().trim();
                    String especialidade = txtEspecialidade.getText().trim();
                    String disponibilidade = txtDisponibilidade.getText().trim();

                    // Validação básica
                    if (nome.isEmpty() || especialidade.isEmpty() || disponibilidade.isEmpty()) {
                        JOptionPane.showMessageDialog(dialog, "Todos os campos são obrigatórios!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Cria um novo objeto Tecnico
                    Tecnico novoTecnico = new Tecnico(null, nome, especialidade, disponibilidade);

                    // Envia para a API
                    Tecnico tecnicoCriado = tecnicoController.createTecnico(novoTecnico);

                    // Se o técnico criado não for nulo, atualiza a tabela e fecha o diálogo
                    if (tecnicoCriado != null) {
                        tableModel.addRow(new Object[]{
                                tecnicoCriado.getId(), // Assume que o ID é retornado na criação
                                nome,
                                especialidade,
                                disponibilidade
                        });
                        JOptionPane.showMessageDialog(dialog, "Técnico cadastrado com sucesso!");
                        dialog.dispose(); // Fecha o diálogo
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Erro ao cadastrar técnico.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao cadastrar técnico: " + ex.getMessage(), "Erro Inesperado", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Mostra o formulário
            dialog.setVisible(true);
        });

        // ActionListener para o botão "Salvar"
        btnSalvarAlteracoes.addActionListener(e -> {
            // Verifica se uma linha está selecionada
            int selectedRow = tecnicoTable.getSelectedRow();
            if (selectedRow != -1) {
                editarTecnico(); // Chama o método de edição
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um técnico para salvar alterações.", "Erro de Seleção", JOptionPane.WARNING_MESSAGE);
            }
        });

        // ActionListener para o botão "Deletar"
        btnDeletarTecnico.addActionListener(e -> {
            // Verifica se uma linha está selecionada
            int selectedRow = tecnicoTable.getSelectedRow();
            if (selectedRow != -1) {
                // Mostra a caixa de diálogo de confirmação com botões personalizados
                String[] options = {"Sim", "Não"}; // Define as opções personalizadas
                int confirm = JOptionPane.showOptionDialog(
                        this,
                        "Tem certeza que deseja deletar este técnico?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null, // Ícone padrão
                        options, // As opções personalizadas
                        options[1] // O botão padrão será "Não"
                );

                // Verifica se o usuário clicou em "Sim"
                if (confirm == 0) { // 0 corresponde a "Sim"
                    try {
                        // Recupera o ID do técnico selecionado
                        String id = String.valueOf(tableModel.getValueAt(selectedRow, 0));

                        // Envia para o controlador para deletar o técnico
                        tecnicoController.deleteTecnico(id); // Supondo que esse método realiza a exclusão

                        // Remove a linha da tabela
                        tableModel.removeRow(selectedRow);

                        JOptionPane.showMessageDialog(this, "Técnico deletado com sucesso!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Erro ao deletar técnico: " + ex.getMessage(), "Erro Inesperado", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um técnico para deletar.", "Erro de Seleção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void editarTecnico() {
        // Verifica se uma linha está selecionada
        int selectedRow = tecnicoTable.getSelectedRow();
        if (selectedRow != -1) {
            // Cria um novo JDialog para editar o técnico
            JDialog dialog = new JDialog((JDialog) null, "Editar Técnico", true);
            dialog.setSize(300, 300);
            dialog.setLayout(new GridLayout(0, 2));

            // Pega os valores da linha selecionada
            String id = String.valueOf(tableModel.getValueAt(selectedRow, 0)); // ID do técnico
            String nome = (String) tableModel.getValueAt(selectedRow, 1);
            String especialidade = (String) tableModel.getValueAt(selectedRow, 2);
            String disponibilidade = (String) tableModel.getValueAt(selectedRow, 3);

            // Adiciona campos de texto para os atributos do técnico
            JTextField txtNome = new JTextField(nome);
            JTextField txtEspecialidade = new JTextField(especialidade);
            JTextField txtDisponibilidade = new JTextField(disponibilidade);

            // Define a altura dos campos
            txtNome.setPreferredSize(new java.awt.Dimension(150, 25));
            txtEspecialidade.setPreferredSize(new java.awt.Dimension(150, 25));
            txtDisponibilidade.setPreferredSize(new java.awt.Dimension(150, 25));

            // Adiciona rótulos e campos ao dialog
            dialog.add(new JLabel("Nome:"));
            dialog.add(txtNome);
            dialog.add(new JLabel("Especialidade:"));
            dialog.add(txtEspecialidade);
            dialog.add(new JLabel("Disponibilidade:"));
            dialog.add(txtDisponibilidade);

            // Botão para salvar as alterações
            JButton btnSubmit = new JButton("Salvar");
            btnSubmit.setPreferredSize(new java.awt.Dimension(150, 25)); // Define a altura do botão
            dialog.add(btnSubmit);

            // Quando o botão for clicado, valida e envia os dados
            btnSubmit.addActionListener(ev -> {
                try {
                    // Recupera os dados dos campos de texto
                    String novoNome = txtNome.getText().trim();
                    String novaEspecialidade = txtEspecialidade.getText().trim();
                    String novaDisponibilidade = txtDisponibilidade.getText().trim();

                    // Validação básica
                    if (novoNome.isEmpty() || novaEspecialidade.isEmpty() || novaDisponibilidade.isEmpty()) {
                        JOptionPane.showMessageDialog(dialog, "Todos os campos são obrigatórios!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Atualiza os dados do técnico
                    Tecnico tecnicoAtualizado = new Tecnico(id, novoNome, novaEspecialidade, novaDisponibilidade);
                    tecnicoController.updateTecnico(tecnicoAtualizado); // Método para atualizar o técnico

                    // Atualiza a tabela com os novos dados
                    tableModel.setValueAt(novoNome, selectedRow, 1);
                    tableModel.setValueAt(novaEspecialidade, selectedRow, 2);
                    tableModel.setValueAt(novaDisponibilidade, selectedRow, 3);

                    JOptionPane.showMessageDialog(dialog, "Técnico atualizado com sucesso!");
                    dialog.dispose(); // Fecha o diálogo
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dialog, "Erro ao atualizar os dados: " + ex.getMessage(), "Erro Inesperado", JOptionPane.ERROR_MESSAGE);
                }
            });

            // Mostra o formulário
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um técnico para editar.", "Erro de Seleção", JOptionPane.WARNING_MESSAGE);
        }
    }
}