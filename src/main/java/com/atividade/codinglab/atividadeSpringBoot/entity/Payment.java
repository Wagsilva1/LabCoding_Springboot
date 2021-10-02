package com.atividade.codinglab.atividadeSpringBoot.entity;

public class Payment {

    private int idTransacao;
    private String numeroCartao;
    private String validadeCartao;
    private String bandeira;

    public Payment(int idTransacao, String numeroCartao, String validadeCartao, String bandeira) {
        this.idTransacao = idTransacao;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.bandeira = bandeira;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

}
