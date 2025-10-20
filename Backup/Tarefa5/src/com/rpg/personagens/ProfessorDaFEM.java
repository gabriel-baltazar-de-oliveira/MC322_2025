package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;

public class ProfessorDaFEM extends Monstro {
    public ProfessorDaFEM() {
        super("ProfessorDaFEM", 100, 20, 50);
    }

    @Override
    public void atacar(Personagem alvo) {
        System.out.println(getNome() + " ataca " + alvo.getNome() + " com provas e livros");
        alvo.receberDano(getForca());
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 10;
        alvo.receberDano(dano);
        System.out.println(getNome() + " usou habilidade especial em " + alvo.getNome() +
                           " causando dano de " + dano);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return super.escolherAcao(alvo);
    }
}