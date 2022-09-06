package br.senai.sc.banco.view;

import br.senai.sc.banco.controller.ContaController;
import br.senai.sc.banco.model.entities.ContaPessoal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoletoInfo extends JFrame {
    private JPanel programa;
    private JTextField codigoBarrasInput;
    private JTextField valorInput;
    private JTextField vencimentoInput;
    private JButton pagarBoletoButton;
    private JButton cancelarButton;

    public BoletoInfo() {
        criarComponentes();
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu = new Menu(Menu.getConta());
                menu.setVisible(true);
            }
        });
        pagarBoletoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContaController conta = new ContaController();
                if (conta.validaValor(Menu.getConta(), valorInput.getText())) {
                    conta.diminuirSaldo(Menu.getConta(), valorInput.getText());
                    JOptionPane.showMessageDialog(null, "Boleto pago!");
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
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
