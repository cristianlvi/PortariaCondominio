package com.cristian.portaria.project.domain.apartamento;

public enum Situacao {

    OCUPADO("ocupado"),
    DESOCUPADO("desocupado");

    private String situacao;

    Situacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }
}
