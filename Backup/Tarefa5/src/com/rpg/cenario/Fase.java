package com.rpg.cenario;

import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import com.rpg.personagens.Personagem;

public interface Fase {
    void iniciar(Heroi heroi);
    boolean isConcluida();
    String getTipoDeCenario();
    String getDescricion();
    java.util.List<Monstro> getMonstros();
    String getNome();
    void executar(Personagem heroi);
}