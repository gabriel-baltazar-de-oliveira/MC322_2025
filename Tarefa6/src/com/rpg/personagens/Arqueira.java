package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoAtaqueBasico;
import java.util.Arrays;
import java.util.List;

public class Arqueira extends Heroi {
    private final int agilidade;
    private final String nomeFlechaEspecial;

    public Arqueira(String nome, int pontosDeVida, int forca, int agilidade, String nomeFlechaEspecial) {
        super(nome, pontosDeVida, forca);
        this.agilidade = agilidade;
        this.nomeFlechaEspecial = nomeFlechaEspecial;
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = getForca();
        alvo.receberDano(dano);
        System.out.println(getNome() + " dispara uma flecha no alvo causando dano de " + dano);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + agilidade * 2;
        alvo.receberDano(dano);
        System.out.println(getNome() + " utiliza a flecha especial " + nomeFlechaEspecial + 
                          " causando dano de " + dano + " em " + alvo.getNome());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return super.escolherAcao(alvo);
    }
}