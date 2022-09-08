package br.senai.sc.banco.model.service;

import br.senai.sc.banco.model.dao.ClienteDAO;
import br.senai.sc.banco.model.entities.Cliente;

public class BancoService {
    ClienteDAO dao = new ClienteDAO();

    public void inserir(Cliente cliente) {
        dao.inserir(cliente);
    }

    public Cliente validar(String cpf) {
        return dao.validar(cpf);
    }
}
