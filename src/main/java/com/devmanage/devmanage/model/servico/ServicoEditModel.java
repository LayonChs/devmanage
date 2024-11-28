package com.devmanage.devmanage.model.servico;

public class ServicoEditModel {

    private int id;
    private String nome;
    private String descricao;
    private String tipo;
    private double valor;

    public ServicoEditModel(int id, String nome, String descricao, String tipo, double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
