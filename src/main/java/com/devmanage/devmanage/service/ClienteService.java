package com.devmanage.devmanage.service;

import com.devmanage.devmanage.model.cliente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ClienteService {
    
    @Autowired
    private JdbcTemplate db;

    public String cadastrarCliente(ClienteModel cliente){
        try{
            String query = "INSERT INTO cliente (nome,telefone,endereco,cpf,senha) VALUES (?,?,?,?,?)";
            db.update(query,cliente.getNome(),cliente.getTelefone(),cliente.getEndereco(),cliente.getCpf(),cliente.getSenha());
            return "Cliente cadastrado com sucesso";
        }catch(DataAccessException e){
            return e.getMessage();
        }
    }

    public List<ClienteModelDTO> listarClientes(){
        try{
            String query = "SELECT * FROM cliente";

            List<Map<String, Object>> clientes = db.queryForList(query);
            List<ClienteModelDTO> clientesDTO = new ArrayList<>();
            for(Map<String, Object> cliente: clientes){
                String nome = cliente.get("nome").toString();
                String telefone = cliente.get("telefone").toString();
                String endereco = cliente.get("endereco").toString();
                String cpf = cliente.get("cpf").toString();

                ClienteModelDTO clienteDTO = new ClienteModelDTO(nome, telefone, endereco, cpf);
                clientesDTO.add(clienteDTO);
            }
            return clientesDTO;
        }catch(DataAccessException e){
            throw new RuntimeException("Erro ao acessar os dados do banco de dados", e);
        }
    }

    public String editarCliente(ClienteEditModel clienteEditado){
        try {
            String query = "UPDATE cliente SET nome = ?, telefone = ?, endereco = ?, cpf = ?, senha = ? WHERE id = ?";
            db.update(query, clienteEditado.getNome(), clienteEditado.getTelefone(), clienteEditado.getEndereco(), clienteEditado.getCpf(), clienteEditado.getSenha(), clienteEditado.getId());
            return "Cliente editado com sucesso";
        } catch (DataAccessException e) {
            return e.getMessage();
        }
    }

    public String excluirCliente(int id){
        try {
            String query = "DELETE FROM cliente WHERE id = ?";
            db.update(query, id);
            return "Cliente excluido com sucesso";
        } catch (DataAccessException e) {
            return e.getMessage();
        }
    }
}
