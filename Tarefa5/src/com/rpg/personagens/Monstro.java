package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoAtaqueBasico;
import com.rpg.items.Item;
import com.rpg.items.Espada;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe abstrata que representa um monstro no sistema de RPG.
 * 
 * <p>Eles possuem habilidades especiais, concedem experiência 
 * quando derrotados, e podem dropar loot.</p>
 * 
 */
public abstract class Monstro extends Personagem {
    protected int xpConcedido;
    protected final List<AcaoDeCombate> acoes;

    /**
     * Construtor para a classe Monstro.
     *
     * @param nome Nome do monstro
     * @param pontosDeVida Pontos de vida iniciais do monstro
     * @param forca Força do monstro para cálculo de dano
     * @param xpConcedido Experiência concedida ao derrotar o monstro
     */
    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
        this.acoes = new ArrayList<>();
        this.acoes.add(new AcaoAtaqueBasico());
    }

    /**
     * Escolhe uma ação de combate aleatória para executar.
     * 
     * @param alvo O combatente alvo da ação
     * @return Uma ação de combate escolhida aleatoriamente
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random rand = new Random();
        return acoes.get(rand.nextInt(acoes.size()));
    }

    /**
     * Adiciona uma nova ação de combate ao repertório do monstro.
     * 
     * @param acao A ação de combate a ser adicionada
     */
    public void adicionarAcao(AcaoDeCombate acao) {
        acoes.add(acao);
    }

    /**
     * Gera um item como recompensa por derrotar o monstro.
     * 
     * <p>Este método implementa o sistema de loot do jogo.
     * Monstros diferentes podem dropar itens diferentes com
     * base em sua raridade e tipo.</p>
     *
     * @return Um item drogado pelo monstro, ou null se não dropar nada
     */
    public Item droparLoot() {
        return new Espada("Espada Perdida", 3, 3);
    }

    /**
     * Retorna a quantidade de experiência concedida ao derrotar o monstro.
     * 
     * @return Experiência concedida pelo monstro
     */
    public int getXpConcedido() {
        return xpConcedido;
    }
}