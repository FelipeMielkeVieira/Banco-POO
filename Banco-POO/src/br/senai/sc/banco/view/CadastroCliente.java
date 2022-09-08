package br.senai.sc.banco.view;

import br.senai.sc.banco.controller.ClienteController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroCliente extends JFrame {
    private JPanel programa;
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JTextField cpfInput;
    private JTextField nomeInput;
    private JTextField enderecoInput;
    private JTextField profissaoInput;
    private JTextField rendaInput;

    public CadastroCliente() {
        criarComponentes();

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Cadastro cadastro = new Cadastro();
                cadastro.setVisible(true);
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nomeInput.getText().isEmpty() ||
                        cpfInput.getText().isEmpty() ||
                        enderecoInput.getText().isEmpty() ||
                        profissaoInput.getText().isEmpty() ||
                        rendaInput.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Há campos vazios! \n" +
                                    "Preencha e tente novamente!");
                } else {
                    ClienteController controller = new ClienteController();
                    try {
                        controller.cadastrar(cpfInput.getText(), nomeInput.getText(),
                                enderecoInput.getText(), profissaoInput.getText(),
                                rendaInput.getText());
                        dispose();
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                        Cadastro cadastro = new Cadastro();
                        cadastro.setVisible(true);
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
            }
        });
    }

    public void criarComponentes() {
        setContentPane(programa);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}
