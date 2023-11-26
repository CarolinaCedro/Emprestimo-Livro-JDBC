package org.application.model.enums;

public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String text;

    Status(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
