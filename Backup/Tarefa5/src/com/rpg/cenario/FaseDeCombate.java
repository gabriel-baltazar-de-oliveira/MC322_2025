package com.rpg.cenario;

import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import com.rpg.personagens.Personagem;
import java.util.List;

public class FaseDeCombate implements Fase {
    private final List<Monstro> monstros;
    private final TipoCenario cenario;
    private boolean concluida = false;

    public FaseDeCombate(List<Monstro> monstros, TipoCenario cenario) {
        this.monstros = monstros;
        this.cenario = cenario;
    }

    @Override
    public String getTipoDeCenario() {
        return cenario.name();
    }

    @Override
    public String getDescricion() {
        return cenario.getDescricao();
    }

    @Override
    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public List<Monstro> getMonstros() {
        return monstros;
    }

    public void aplicarEfeitos(Heroi heroi) {
        cenario.aplicarEfeitos(heroi);
    }

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("Fase de combate iniciada para o herói " + heroi.getNome());
    }

    @Override
    public String getNome() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void executar(Personagem heroi) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}