package com.devmanage.devmanage.model.pedido;

public class PedidoModel {

    private int clienteId;
    private int servicoId;
    private String observacao;
    
    public PedidoModel(int clienteId, int servicoId, String observacao){
        this.clienteId = clienteId;
        this.servicoId = servicoId;
        this.observacao = observacao;
    }

    public int getclienteId() {
        return clienteId;
    }

    public void setclienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getServicoId() {
        return servicoId;
    }

    public void setServicoId(int servicoId) {
        this.servicoId = servicoId;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
}
