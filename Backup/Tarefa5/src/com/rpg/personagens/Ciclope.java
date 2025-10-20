package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

public class Ciclope extends Monstro {
    public Ciclope() {
        super("Ciclope", 200, 30, 70);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca " + alvo.getNome() + " com um golpe forte!");
        alvo.receberDano(getForca());
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 20;
        alvo.receberDano(dano);
        System.out.println(getNome() + " lançou ataque devastador em " + alvo.getNome() +
                           " causando dano de " + dano);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return super.escolherAcao(alvo);
    }
}