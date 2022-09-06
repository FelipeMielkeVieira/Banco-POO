package br.senai.sc.banco.view;

import br.senai.sc.banco.controller.ContaController;
import br.senai.sc.banco.model.entities.ContaPessoal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements Runnable {
    private JPanel programa;
    private JButton cadastrarButton;
    private JButton entrarButton;
    private JTextField numeroCartaoInput;
    private JPasswordField senhaInput;

    public Login() {
        criarComponentes();

        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContaController controller = new ContaController();
                try {
                    ContaPessoal conta = controller.validaLogin(numeroCartaoInput.getText(), senhaInput.getText());
                    dispose();
                    Menu menu = new Menu(conta);
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


    public static void main(String[] args) {
        Login login = new Login();
        login.run();
    }

    @Override
    public void run() {
        if (!isVisible()) {
            setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "A janela já está aberta!");
        }
    }
}
