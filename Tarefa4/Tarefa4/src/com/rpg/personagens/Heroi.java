package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoAtaqueBasico;
import java.util.Arrays;
import java.util.List;

public class Heroi extends Personagem {
    private final List<AcaoDeCombate> acoes;

    public Heroi(String nome, int vidaMaxima, int forca) {
        super(nome, vidaMaxima, forca);
        this.acoes = Arrays.asList(new AcaoAtaqueBasico());
    }

    @Override
    public void atacar(Personagem alvo) {
        acoes.get(0).executar(this, alvo);
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
        return acoes.get(0);
    }
}