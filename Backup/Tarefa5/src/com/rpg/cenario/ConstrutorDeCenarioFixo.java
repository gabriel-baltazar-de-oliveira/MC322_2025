package com.rpg.cenario;

import com.rpg.personagens.Ciclope;
import com.rpg.personagens.ProfessorDaFEM;
import com.rpg.personagens.ElefantePsiquico;
import com.rpg.personagens.Monstro;
import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();

        // Fase 1: Ciclope no Bar
        List<Monstro> monstrosFase1 = new ArrayList<>();
        Ciclope ciclope = new Ciclope();
        aplicarDificuldade(ciclope, dificuldade);
        monstrosFase1.add(ciclope);
        fases.add(new FaseDeCombate(monstrosFase1, TipoCenario.BAR));

        // Fase 2: ProfessorDaFEM no Castelo
        List<Monstro> monstrosFase2 = new ArrayList<>();
        ProfessorDaFEM professor = new ProfessorDaFEM();
        aplicarDificuldade(professor, dificuldade);
        monstrosFase2.add(professor);
        fases.add(new FaseDeCombate(monstrosFase2, TipoCenario.CASTELO));

        // Fase 3: ElefantePsíquico na Faculdade
        List<Monstro> monstrosFase3 = new ArrayList<>();
        ElefantePsiquico elefante = new ElefantePsiquico();
        aplicarDificuldade(elefante, dificuldade);
        monstrosFase3.add(elefante);
        fases.add(new FaseDeCombate(monstrosFase3, TipoCenario.FACULDADE));

        return fases;
    }

    private void aplicarDificuldade(Monstro monstro, Dificuldade dificuldade) {
        int novaVida = (int)(monstro.getPontosDeVida() * dificuldade.getMultiplicadorVida());
        int novaForca = (int)(monstro.getForca() * dificuldade.getMultiplicadorForca());
        monstro.setPontosDeVida(novaVida);
        monstro.setForca(novaForca);
    }
}