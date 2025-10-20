package com.rpg.personagens;

public class Ciclope extends Monstro {
    
    public Ciclope() {
        // Agora esta chamada funciona, pois o construtor em Monstro existe!
        super("Ciclope", 200, 30);
        
        setChanceDrop(0.5); // 50% de chance de drop
        adicionarPossivelDrop("ESPADA_BASICA");
    }

    @Override
    public void atacar(Personagem alvo) {
        // O método getDanoFisico() agora existe, herdado de Personagem.
        int dano = this.getDanoFisico();
        System.out.println(getNome() + " ataca " + alvo.getNome() + " com um golpe forte, causando " + dano + " de dano!");
        alvo.receberDano(dano);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        // O método getDanoFisico() agora existe, herdado de Personagem.
        int dano = this.getDanoFisico() + 20;
        System.out.println(getNome() + " usou um ataque devastador em " + alvo.getNome() + " causando " + dano + " de dano!");
        alvo.receberDano(dano);
    }
}