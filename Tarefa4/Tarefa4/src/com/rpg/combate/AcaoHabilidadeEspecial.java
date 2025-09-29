package com.rpg.combate;

public class AcaoHabilidadeEspecial implements AcaoDeCombate {
    private final int multiplicador;
    private final String nomeHabilidade;

    public AcaoHabilidadeEspecial(String nomeHabilidade, int multiplicador) {
        this.nomeHabilidade = nomeHabilidade;
        this.multiplicador = multiplicador;
    }

    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int dano = usuario.getForca() + multiplicador;
        alvo.receberDano(dano);
        System.out.println(usuario.getNome() + " usa " + nomeHabilidade + " causando dano de " + dano + " em " + alvo.getNome());
    }
}