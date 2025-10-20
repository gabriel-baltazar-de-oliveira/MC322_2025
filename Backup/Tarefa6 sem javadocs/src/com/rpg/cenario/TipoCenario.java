package com.rpg.cenario;

import com.rpg.personagens.Heroi;

public enum TipoCenario {
    BAR("Bar da esquina") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Você bebe e recupera 10 pontos de vida!");
            heroi.receberCura(10);
        }
    },
    FACULDADE("Uma faculdade escura e úmida") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("A escuridão drena sua energia, você perde 5 pontos de vida!");
            heroi.receberDano(5);
        }
    },
    CASTELO("Um nobre castelo") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Você impõe respeito, sua força aumenta em 2");
            heroi.setForca(heroi.getForca() + 2);
        }
    };

    protected final String descricao;

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public abstract void aplicarEfeitos(Heroi heroi);
}