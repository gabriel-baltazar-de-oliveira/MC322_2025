package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoAtaqueBasico;
import java.util.Arrays;
import java.util.List;

public class Paladino extends Heroi {
    private final int fe; // atributo único
    private final String poderSagrado;

    public Paladino(String nome, int pontosDeVida, int forca, int fe, String poderSagrado) {
        super(nome, pontosDeVida, forca);
        this.fe = fe;
        this.poderSagrado = poderSagrado;
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = getForca();
        alvo.receberDano(dano);
        System.out.println(getNome() + " golpeia o alvo com a espada sagrada causando dano de " + dano);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + fe * 2;
        alvo.receberDano(dano);
        System.out.println(getNome() + " invoca o poder sagrado " + poderSagrado + 
                          " causando dano de " + dano + " em " + alvo.getNome());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return super.escolherAcao(alvo);
    }
}