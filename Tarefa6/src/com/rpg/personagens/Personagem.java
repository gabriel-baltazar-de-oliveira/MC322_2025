package com.rpg.personagens;

import com.fasterxml.jackson.annotation.JsonIgnore; // <-- IMPORT NECESSÁRIO
import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.GerenciadorAcoesCombate;

public abstract class Personagem implements Combatente {

    protected String nome;
    protected int vidaMaxima;
    protected int pontosDeVida;
    protected int forca;
    protected int defesa;

    public Personagem(String nome, int vidaMaxima, int forca) {
        this.nome = nome;
        this.vidaMaxima = vidaMaxima;
        this.forca = forca;
        this.pontosDeVida = vidaMaxima;
        this.defesa = 5;
    }

    public Personagem() {
        this.defesa = 5;
    }

    @Override
    public String getNome() { return nome; }

    public void receberDano(int dano) {
        int danoReduzido = dano - this.defesa;
        if (danoReduzido < 1) {
            danoReduzido = 1;
        }
        this.pontosDeVida -= danoReduzido;
        if (this.pontosDeVida < 0) { this.pontosDeVida = 0; }
        System.out.println(" (Dano efetivo recebido: " + danoReduzido + ")");
    }

    public void receberCura(int cura) {
        this.pontosDeVida += cura;
        if (this.pontosDeVida > this.vidaMaxima) { this.pontosDeVida = this.vidaMaxima; }
    }

    public boolean estaVivo() { return this.pontosDeVida > 0; }
    public int getPontosDeVida() { return pontosDeVida; }
    public void setPontosDeVida(int pontosDeVida) { this.pontosDeVida = pontosDeVida; }
    public int getForca() { return forca; }
    public void setForca(int forca) { this.forca = forca; }
    public int getVidaMaxima() { return vidaMaxima; }
    public void setVidaMaxima(int vidaMaxima) { this.vidaMaxima = vidaMaxima; }
    public int getDefesa() { return this.defesa; }
    public void setDefesa(int defesa) { this.defesa = defesa; }

    // --- MÉTODOS DE CÁLCULO IGNORADOS PELO SAVE ---

    @JsonIgnore // <-- DIZ PARA O JACKSON IGNORAR ESTE MÉTODO AO SALVAR/CARREGAR
    @Override
    public int getDanoFisico() { 
        return this.forca; 
    }

    @JsonIgnore // <-- DIZ PARA O JACKSON IGNORAR ESTE MÉTODO AO SALVAR/CARREGAR
    @Override
    public int getDanoMagico() { 
        return 0; 
    }
    
    //------------------------------------------------

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return GerenciadorAcoesCombate.getAcao("ATAQUE_BASICO");
    }

    public abstract void atacar(Personagem alvo);
    public abstract void usarHabilidadeEspecial(Personagem alvo);
}