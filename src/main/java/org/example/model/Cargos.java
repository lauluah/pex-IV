package org.example.model;

public enum Cargos {
    ATENDENTE("Atendente"),
    PIZZAIOLO("Pizzaiolo"),
    GERENTE("Gerente"),
    ENTREGADOR("Entregador"),
    LIMPEZA("limpeza");

    private final String descricao;

    Cargos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
