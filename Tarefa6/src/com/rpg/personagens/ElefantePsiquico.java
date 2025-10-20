package com.rpg.personagens;

/**
 * Classe representando o monstro ElefantePsiquico.
 */
public class ElefantePsiquico extends Monstro {
    
    public ElefantePsiquico() {
        // Construtor corrigido: nome, vidaMaxima, forca
        super("Elefante Psíquico", 150, 5); // Pouquíssima força física
        
        setChanceDrop(0.35); // 35% de chance
        adicionarPossivelDrop("VARINHA_INICIANTE");
        adicionarPossivelDrop("ARCO_SIMPLES");
    }

    // Sobrescreve o Dano Mágico padrão
    @Override
    public int getDanoMagico() {
        return 25; // Dano mágico considerável
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getDanoMagico(); // Usa o dano mágico!
        System.out.println(getNome() + " dispara uma onda mental em " + alvo.getNome() + ", causando " + dano + " de dano!");
        alvo.receberDano(dano);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = this.getDanoMagico() + 15;
        System.out.println(getNome() + " usou um ataque psíquico massivo em " + alvo.getNome() + ", causando " + dano + " de dano!");
        alvo.receberDano(dano);
    }
}