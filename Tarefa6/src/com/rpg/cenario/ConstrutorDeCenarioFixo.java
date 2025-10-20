package com.rpg.cenario;

import com.rpg.personagens.Ciclope;
import com.rpg.personagens.ElefantePsiquico;
import com.rpg.personagens.Monstro;
import com.rpg.personagens.ProfessorDaFEM;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<Fase> gerar(int numeroDeFases, Dificuldade dificuldade) {
        List<Fase> fases = new ArrayList<>();
        
        // --- FASE 1 ---
        Monstro ciclope = new Ciclope();
        ajustarStatusPorDificuldade(ciclope, dificuldade);
        // A chamada agora passa os 3 argumentos corretos
        fases.add(new FaseDeCombate(
            new ArrayList<>(Arrays.asList(ciclope)),
            TipoCenario.BAR,
            "Bar da esquina" // <-- O terceiro argumento (a descrição) estava faltando
        ));

        // --- FASE 2 ---
        Monstro professor = new ProfessorDaFEM();
        ajustarStatusPorDificuldade(professor, dificuldade);
        fases.add(new FaseDeCombate(
            new ArrayList<>(Arrays.asList(professor)),
            TipoCenario.CASTELO,
            "Um nobre castelo" // <-- O terceiro argumento (a descrição) estava faltando
        ));

        // --- FASE 3 ---
        Monstro elefante = new ElefantePsiquico();
        ajustarStatusPorDificuldade(elefante, dificuldade);
        fases.add(new FaseDeCombate(
            new ArrayList<>(Arrays.asList(elefante)),
            TipoCenario.FACULDADE,
            "Uma faculdade escura e úmida" // <-- O terceiro argumento (a descrição) estava faltando
        ));
        
        return fases;
    }

    private void ajustarStatusPorDificuldade(Monstro monstro, Dificuldade dificuldade) {
        int vidaBase = monstro.getVidaMaxima();
        int forcaBase = monstro.getForca();
        int vidaAjustada = (int) (vidaBase * dificuldade.getMultiplicadorVida());
        int forcaAjustada = (int) (forcaBase * dificuldade.getMultiplicadorForca());
        monstro.setVidaMaxima(vidaAjustada);
        monstro.setPontosDeVida(vidaAjustada);
        monstro.setForca(forcaAjustada);
    }
}