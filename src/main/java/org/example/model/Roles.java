package org.example.model;

public enum Roles {
    ATENDENTE("Atendente"),
    PIZZAIOLO("Pizzaiolo"),
    GERENTE("Gerente"),
    ENTREGADOR("Entregador"),
    LIMPEZA("limpeza");

    private final String descricao;

    Roles(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
