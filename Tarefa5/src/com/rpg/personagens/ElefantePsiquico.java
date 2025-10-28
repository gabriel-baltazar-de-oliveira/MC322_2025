package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

public class ElefantePsiquico extends Monstro {
    public ElefantePsiquico() {
        super("ElefantePsíquico", 150, 25, 60);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca " + alvo.getNome() + " com poderes mentais!");
        alvo.receberDano(getForca());
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 15;
        alvo.receberDano(dano);
        System.out.println(getNome() + " usou ataque psíquico em " + alvo.getNome() +
                           " causando dano de " + dano);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return super.escolherAcao(alvo);
    }
}