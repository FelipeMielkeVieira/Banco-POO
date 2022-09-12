package br.senai.sc.banco.view;

import br.senai.sc.banco.controller.ContaController;

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
                try {
                    conta.diminuirSaldo(Menu.getConta(), valorInput.getText());
                    JOptionPane.showMessageDialog(null, "Boleto pago!");
                    dispose();
                    Menu menu = new Menu(Menu.getConta());
                    menu.setVisible(true);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage());
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
