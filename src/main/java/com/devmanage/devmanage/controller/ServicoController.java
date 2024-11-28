package com.devmanage.devmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmanage.devmanage.model.servico.ServicoEditModel;
import com.devmanage.devmanage.model.servico.ServicoModel;
import com.devmanage.devmanage.model.servico.ServicoModelDTO;
import com.devmanage.devmanage.service.ServicoService;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping("/cadastrarServico")
    public String cadastrarServico(@RequestBody ServicoModel servico){
        return servicoService.cadastrarServico(servico);
    }

    @GetMapping("/listarServicos")
    public List<ServicoModelDTO> listarServicos(){
        return servicoService.listarServicos();
    }

    @DeleteMapping("/excluirServico/{id}")
    public String excluirServico(@PathVariable int id){
        return servicoService.excluirServico(id);
    }

    @PutMapping("/editarServico")
    public String editarServico(@RequestBody ServicoEditModel servicoEditado){
        return servicoService.editarServico(servicoEditado);
    }

}
