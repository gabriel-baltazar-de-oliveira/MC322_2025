package com.rpg.personagens;

/**
 * Classe representando o monstro ProfessorDaFEM.
 */
public class ProfessorDaFEM extends Monstro {
    
    public ProfessorDaFEM() {
        // Construtor corrigido: nome, vidaMaxima, forca
        super("Professor da FEM", 100, 10); 
        
        setChanceDrop(0.4); // 40% de chance
        adicionarPossivelDrop("VARINHA_INICIANTE");
    }

    // Sobrescreve o Dano Mágico padrão para dar a ele um ataque especial
    @Override
    public int getDanoMagico() {
        return 35; // Dano mágico alto!
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = this.getDanoMagico(); // Usa o dano mágico!
        System.out.println(getNome() + " aplica uma prova surpresa em " + alvo.getNome() + ", causando " + dano + " de dano psíquico!");
        alvo.receberDano(dano);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = this.getDanoMagico() + 20; // Habilidade espcial é ainda mais forte
        System.out.println(getNome() + " agenda a entrega de um PI para amanhã, causando " + dano + " de dano crítico!");
        alvo.receberDano(dano);
    }
}