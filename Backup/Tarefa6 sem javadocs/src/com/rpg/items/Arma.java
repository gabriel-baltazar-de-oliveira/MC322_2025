package com.rpg.items;

/**
 * Classe base abstrata para todos os itens que são armas.
 * Implementa a interface Item para fornecer lógica base de bônus.
 */
public abstract class Arma implements Item {

    protected String nome;
    protected int dano;
    // O construtor de Espada usa 'alcance' e os outros 'minNivel'. 
    // Vamos usar um atributo genérico 'valorExtra' para simplificar.
    protected int valorExtra;

    public Arma(String nome, int dano, int valorExtra) {
        this.nome = nome;
        this.dano = dano;
        this.valorExtra = valorExtra;
    }

    // --- MÉTODOS DO CONTRATO "ITEM" IMPLEMENTADOS AQUI ---

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public int getBonusForca() {
        // O bônus de força de uma arma é o seu dano base.
        return this.dano;
    }

    @Override
    public int getBonusVida() {
        // Armas normalmente não dão bônus de vida.
        return 0;
    }

    // --- Métodos específicos de Arma ---
    public int getDano() {
        return this.dano;
    }
}