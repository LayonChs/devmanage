package com.devmanage.devmanage.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmanage.devmanage.model.cliente.ClienteEditModel;
import com.devmanage.devmanage.model.cliente.ClienteModel;
import com.devmanage.devmanage.model.cliente.ClienteModelDTO;
import com.devmanage.devmanage.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cadastrarCliente")
    public String cadastrarCliente(@RequestBody ClienteModel cliente){
        return clienteService.cadastrarCliente(cliente);
    }

    @GetMapping("/listarClientes")
    public List<ClienteModelDTO> listarClientes(){
        return clienteService.listarClientes();
    }

    @DeleteMapping("/excluirCliente/{id}")
    public String excluirCliente(@PathVariable int id){
        return clienteService.excluirCliente(id);
    }

    @PutMapping("/editarCliente")
    public String editarCliente(@RequestBody ClienteEditModel clienteEditado){
        return clienteService.editarCliente(clienteEditado);
    }

}
