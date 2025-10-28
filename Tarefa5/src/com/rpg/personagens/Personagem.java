package com.rpg.personagens;

import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoDeCombate;

/**
 * Classe abstrata que representa um personagem no sistema de RPG.
 * 
 * <p>Esta classe serve como base para todos os personagens do jogo,
 * tanto heróis controlados pelo jogador quanto monstros.
 * Define atributos básicos e comportamentos comuns a todos
 * os personagens.</p>
 * 
 */
public abstract class Personagem implements Combatente {
    protected String nome;
    protected int pontosDeVida;
    protected int forca;

    /**
     * Construtor para a classe Personagem.
     *
     * @param nome Nome do personagem
     * @param pontosDeVida Pontos de vida iniciais do personagem
     * @param forca Força do personagem para cálculo de dano
     */
    public Personagem(String nome, int pontosDeVida, int forca) {
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receberDano(int dano) {
        pontosDeVida -= dano;
        if (pontosDeVida < 0) pontosDeVida = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void receberCura(int cura) {
        pontosDeVida += cura;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void atacar(Personagem alvo);

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void usarHabilidadeEspecial(Personagem alvo);

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract AcaoDeCombate escolherAcao(Combatente alvo);

    /**
     * {@inheritDoc}
     */
    @Override
    public int getForca() {
        return forca;
    }

    /**
     * Retorna os pontos de vida atuais do personagem.
     * 
     * @return Pontos de vida atuais do personagem
     */
    public int getPontosDeVida() {
        return pontosDeVida;
    }

    /**
     * Define a força do personagem.
     * 
     * <p>Este método pode ser usado para modificar temporariamente
     * a força do personagem através de buffs, debuffs, ou equipamentos.</p>
     *
     * @param novaForca Novo valor para a força do personagem
     */
    public void setForca(int novaForca) {
        this.forca = novaForca;
    }

    /**
     * Define os pontos de vida do personagem.
     * 
     * <p>Pode contornar mecanismos normais
     * de dano e cura. Geralmente usado para inicialização ou
     * efeitos especiais.</p>
     *
     * @param pontosDeVida Novo valor para os pontos de vida
     */
    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }
}