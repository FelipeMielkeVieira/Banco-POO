package br.senai.sc.banco.view;

import br.senai.sc.banco.controller.ContaController;
import br.senai.sc.banco.model.entities.TipoConta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame {
    private JPanel programa;
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JButton cadastrarPessoaButton;
    private JTextField numeroInput;
    private JTextField agenciaInput;
    private JTextField cpfInput;
    private JPasswordField senhaInput;
    private JPasswordField confirmarSenhaInput;
    private JComboBox tipoContaInput;

    public Cadastro() {
        criarComponentes();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });
        cadastrarPessoaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CadastroCliente cadastroCliente = new CadastroCliente();
                cadastroCliente.setVisible(true);
            }
        });
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numeroInput.getText().isEmpty() ||
                        agenciaInput.getText().isEmpty() ||
                        senhaInput.getText().isEmpty() ||
                        confirmarSenhaInput.getText().isEmpty() ||
                        cpfInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Há campos vazios! \n" +
                                    "Preencha e tente novamente!");
                } else {
                    String dadoAdicional = null;
                    switch (((TipoConta) tipoContaInput.getSelectedItem()).getTipo()) {
                        case "Poupança":
                            dadoAdicional = JOptionPane.showInputDialog(null, "Taxa percentual: ");
                            break;
                        case "Crédito":
                            dadoAdicional = JOptionPane.showInputDialog(null, "Limite");
                            break;
                    }
                    if (!senhaInput.getText().equals(confirmarSenhaInput.getText())) {
                        JOptionPane.showMessageDialog(null, "As senhas não conferem! \nTente novamente!");
                    } else {
                        ContaController controller = new ContaController();
                        try {
                            controller.cadastrar(numeroInput.getText(), agenciaInput.getText(),
                                    senhaInput.getText(),
                                    cpfInput.getText(), (TipoConta) tipoContaInput.getSelectedItem(), dadoAdicional);
                            dispose();
                            JOptionPane.showMessageDialog(null, "Conta cadastrado com sucesso!");
                            Login login = new Login();
                            login.setVisible(true);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage());
                        }
                    }
                }
            }
        });
    }

    public void criarComponentes() {
        tipoContaInput.setModel(new DefaultComboBoxModel(TipoConta.values()));
        setContentPane(programa);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}
