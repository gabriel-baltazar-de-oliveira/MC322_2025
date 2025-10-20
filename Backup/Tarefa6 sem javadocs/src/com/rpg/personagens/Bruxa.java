package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoAtaqueBasico;
import java.util.Arrays;
import java.util.List;

public class Bruxa extends Heroi {
    private final int inteligencia;
    private final String nomeFeitico;

    public Bruxa(String nome, int pontosDeVida, int forca, int inteligencia, String nomeFeitico) {
        super(nome, pontosDeVida, forca);
        this.inteligencia = inteligencia;
        this.nomeFeitico = nomeFeitico;
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = getForca();
        alvo.receberDano(dano);
        System.out.println(getNome() + " ataca o alvo com magia causando dano de " + dano);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + inteligencia * 2;
        alvo.receberDano(dano);
        System.out.println(getNome() + " lança o feitiço " + nomeFeitico + 
                          " causando dano de " + dano + " em " + alvo.getNome());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return super.escolherAcao(alvo);
    }
}