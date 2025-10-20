package com.rpg.items;

public abstract class Arma implements Item {
    protected String nome;
    protected int dano;
    protected int alcance;

    public Arma(String nome, int dano, int alcance) {
        this.nome = nome;
        this.dano = dano;
        this.alcance = alcance;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }

    public int getAlcance() {
        return alcance;
    }
}