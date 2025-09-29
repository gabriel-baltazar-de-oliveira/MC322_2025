package com.rpg.cenario;

public enum Dificuldade {
    FACIL(0.7, 0.8, "Fácil"),
    MEDIA(1.0, 1.0, "Média"), 
    DIFICIL(1.3, 1.2, "Difícil");

    private final double multiplicadorVida;
    private final double multiplicadorForca;
    private final String descricao;

    Dificuldade(double multiplicadorVida, double multiplicadorForca, String descricao) {
        this.multiplicadorVida = multiplicadorVida;
        this.multiplicadorForca = multiplicadorForca;
        this.descricao = descricao;
    }

    public double getMultiplicadorVida() {
        return multiplicadorVida;
    }

    public double getMultiplicadorForca() {
        return multiplicadorForca;
    }

    public String getDescricao() {
        return descricao;
    }
}