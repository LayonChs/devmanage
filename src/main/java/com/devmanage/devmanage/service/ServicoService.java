package com.devmanage.devmanage.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.devmanage.devmanage.model.servico.ServicoEditModel;
import com.devmanage.devmanage.model.servico.ServicoModel;
import com.devmanage.devmanage.model.servico.ServicoModelDTO;

@Service
public class ServicoService {
    
    @Autowired
    private JdbcTemplate db;

    public String cadastrarServico(ServicoModel servico){
        try{
            String query = "INSERT INTO servico (nome,descricao,tipo,valor) VALUES (?,?,?,?)";
            db.update(query, servico.getNome(),servico.getDescricao(),servico.getTipo(),servico.getValor());
            return "Servico cadastrado com sucesso"; 
        }catch(DataAccessException e){
            return e.getMessage();
        }
    }

    public List<ServicoModelDTO> listarServicos(){
        try {
            List<ServicoModelDTO> servicosDTO = new ArrayList<>();
            String query = "SELECT * FROM servico";
            List<Map<String, Object>> servicos = db.queryForList(query);

            if(servicos.size() > 0){
                for(Map<String, Object> servico : servicos){
                    String nome = servico.get("nome").toString();
                    String descricao = servico.get("descricao").toString();
                    String tipo = servico.get("tipo").toString();
                    double valor = (double) servico.get("valor");
                    ServicoModelDTO servicoDTO = new ServicoModelDTO(nome,descricao,tipo,valor);

                    servicosDTO.add(servicoDTO);
                }
            }
            return servicosDTO;
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao acessar os dados do banco de dados", e);
        }
    }

    public String editarServico(ServicoEditModel servicoEditado){
        try {
            String query = "UPDATE servico SET nome = ?, descricao = ?, tipo = ?, valor = ? WHERE id = ?";
            db.update(query,servicoEditado.getNome(),servicoEditado.getDescricao(),servicoEditado.getTipo(),servicoEditado.getValor(),servicoEditado.getId());
            return "Servico editado com sucesso";
        } catch (DataAccessException e) {
            return e.getMessage();
        }
    }

    public String excluirServico(int id){
        try {
            String query = "DELETE FROM servico WHERE id = ?";
            db.update(query, id);
            return "Servico excluido com sucesso";
        } catch (DataAccessException e) {
            return e.getMessage();
        }
    }
}
