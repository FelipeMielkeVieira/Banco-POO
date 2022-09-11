package br.senai.sc.banco.model.dao;

import br.senai.sc.banco.model.Conexao;
import br.senai.sc.banco.model.entities.ContaPessoal;
import br.senai.sc.banco.view.Login;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BancoDAO {

    public ContaPessoal selecionarPorCartao(String numeroCartao) {
        for (ContaPessoal conta : Login.banco.getListaContas()) {
            if (conta.getNumero().equals(numeroCartao)) {
                return conta;
            }
        }
        throw new RuntimeException("Conta não encontrada");
    }

    public void inserir(ContaPessoal conta) {
        Login.banco.getListaContas().add(conta);
    }
}
