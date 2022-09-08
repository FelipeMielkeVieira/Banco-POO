package br.senai.sc.banco.model.dao;

import br.senai.sc.banco.model.entities.Cliente;

import java.util.ArrayList;

public class ClienteDAO {
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void inserir(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente validar(String cpf) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        throw new RuntimeException("CPF inválido!");
    }
}
