package com.rpg.personagens;

import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoDeCombate;

public abstract class Personagem implements Combatente {
    protected String nome;
    protected int pontosDeVida;
    protected int forca;

    public Personagem(String nome, int pontosDeVida, int forca) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    @Override
    public void receberDano(int dano) {
        pontosDeVida -= dano;
        if (pontosDeVida < 0) pontosDeVida = 0;
    }

    @Override
    public void receberCura(int cura) {
        pontosDeVida += cura;
    }

    @Override
    public abstract void atacar(Personagem alvo);

    @Override
    public abstract void usarHabilidadeEspecial(Personagem alvo);

    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    @Override
    public int getForca() {
        return forca;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setForca(int novaForca) {
        this.forca = novaForca;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }
}