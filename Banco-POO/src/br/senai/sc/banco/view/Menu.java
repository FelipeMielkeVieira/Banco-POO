package br.senai.sc.banco.view;

import br.senai.sc.banco.model.entities.ContaCorrente;
import br.senai.sc.banco.model.entities.ContaCredito;
import br.senai.sc.banco.model.entities.ContaPessoal;
import br.senai.sc.banco.model.entities.ContaPoupanca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private static ContaPessoal conta;
    private JPanel programa;
    private JButton depositarButton;
    private JButton sacarButton;
    private JButton imprimirDadosButton;
    private JButton pagarBoletoButton;
    private JButton transferirButton;
    private JButton sairButton;

    public Menu(ContaPessoal contaLogin) {
        conta = contaLogin;
        criarComponentes();
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conta = null;
                dispose();
                Login login = new Login();
                login.run();
            }

        });
        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        imprimirDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        pagarBoletoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BoletoInfo boleto = new BoletoInfo();
                dispose();
                boleto.setVisible(true);
            }
        });
    }

    public void criarComponentes() {
        setContentPane(programa);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

        if (conta instanceof ContaCredito) {
            transferirButton.setVisible(false);
        } else if (conta instanceof ContaPoupanca) {
            pagarBoletoButton.setVisible(false);
        }
    }

    public static ContaPessoal getConta() {
        return conta;
    }
}
