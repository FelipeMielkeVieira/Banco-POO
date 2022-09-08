package br.senai.sc.banco.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private JButton novoClienteButton;
    private JPanel painelPrincipal;
    private JButton novaContaButton;
    private JButton entrarEmUmaContaButton;
    private JButton encerrarButton;

    public MenuPrincipal() {
        criarComponentes();
        novoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CadastroCliente cadastroCliente = new CadastroCliente();
                cadastroCliente.setVisible(true);
            }
        });
        novaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Cadastro cadastro = new Cadastro();
                cadastro.setVisible(true);
            }
        });
        entrarEmUmaContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        });
        encerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    private void criarComponentes() {
        setContentPane(painelPrincipal);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
}
