package com.devmanage.devmanage.model.pedido;

public class PedidoMolelDTO {
 
    private String clienteNome;
    private String clienteCpf;
    private String servicoNome;
    private double servicoValor;
    private String observacao;
    
    public PedidoMolelDTO(String clienteNome, String clienteCpf, String servicoNome, double servicoValor, String observacao) {
        this.clienteNome = clienteNome;
        this.clienteCpf = clienteCpf;
        this.servicoNome = servicoNome;
        this.servicoValor = servicoValor;
        this.observacao = observacao;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String clienteCpf) {
        this.clienteCpf = clienteCpf;
    }

    public String getServicoNome() {
        return servicoNome;
    }

    public void setServicoNome(String servicoNome) {
        this.servicoNome = servicoNome;
    }

    public double getServicoValor() {
        return servicoValor;
    }

    public void setServicoValor(double servicoValor) {
        this.servicoValor = servicoValor;
    }

    public String getObservacao(){
        return observacao;
    }

    public void setObservacao(String observacao){
        this.observacao = observacao;
    }

}

