package br.senai.sc.banco.view;

import br.senai.sc.banco.controller.ContaController;
import br.senai.sc.banco.model.entities.ContaCorrente;
import br.senai.sc.banco.model.entities.ContaCredito;
import br.senai.sc.banco.model.entities.ContaPessoal;
import br.senai.sc.banco.model.entities.ContaPoupanca;

import javax.print.attribute.standard.JobName;
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
                String valor = JOptionPane.showInputDialog(null, "Insira o valor a ser depositado");
                if(valor != null) {
                    ContaController contaController = new ContaController();
                    contaController.depositar(conta, valor);
                    JOptionPane.showMessageDialog(null, "Valor depositado com sucesso!");
                }
            }
        });
        sacarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String valor = JOptionPane.showInputDialog(null, "Insira o valor a ser sacado");
                    if(valor != null) {
                        ContaController contaController = new ContaController();
                        contaController.diminuirSaldo(conta, valor);
                        JOptionPane.showMessageDialog(null, "Valor retirado com sucesso!");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
            }
        });
        imprimirDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContaController controller = new ContaController();
                JOptionPane.showMessageDialog(null, controller.imprimirDados(conta));
            }
        });
        transferirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContaController controller = new ContaController();
                String numeroDestinatario = JOptionPane.showInputDialog(null, "Informe o número da conta a receber");
                String valor = JOptionPane.showInputDialog(null, "Informe o valor a ser transferido");

                try {
                    controller.transferir(conta, numeroDestinatario, valor);
                    JOptionPane.showMessageDialog(null, "Valor transferido com sucesso!");
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
                }
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
