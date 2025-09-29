package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoAtaqueBasico;
import com.rpg.items.Item;
import com.rpg.items.Espada;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monstro extends Personagem {
    protected int xpConcedido;
    protected final List<AcaoDeCombate> acoes;

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
        this.acoes = new ArrayList<>();
        this.acoes.add(new AcaoAtaqueBasico());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random rand = new Random();
        return acoes.get(rand.nextInt(acoes.size()));
    }

    public void adicionarAcao(AcaoDeCombate acao) {
        acoes.add(acao);
    }

    public Item droparLoot() {
        return new Espada("Espada Perdida", 3, 3);
    }

    public int getXpConcedido() {
        return xpConcedido;
    }
}