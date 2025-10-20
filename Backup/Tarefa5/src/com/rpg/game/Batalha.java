package com.rpg.game;

import com.rpg.cenario.Fase;
import com.rpg.personagens.Personagem;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma aventura completa no RPG, contendo o herói e as fases.
 * Pode ser salva/carregada via GerenciadorDePersistencia.
 */
public class Batalha {

    private String nomeJogo;
    private Personagem heroi;
    private List<Fase> fases;
    private int faseAtualIndex;

    public Batalha() {
        // Necessário para JAXB
        this.fases = new ArrayList<>();
        this.faseAtualIndex = 0;
    }

    public Batalha(String nomeJogo, Personagem heroi, List<Fase> fases) {
        this.nomeJogo = nomeJogo;
        this.heroi = heroi;
        this.fases = fases != null ? fases : new ArrayList<>();
        this.faseAtualIndex = 0;
    }

    // -----------------------------
    // Métodos principais
    // -----------------------------

    /** Carrega o estado do jogo salvo via GerenciadorDePersistencia */
    public static Batalha carregarJogo(String nomeJogo) {
        Batalha b = GerenciadorDePersistencia.carregarBatalha(nomeJogo);
        if (b == null) {
            System.out.println("Nenhum jogo salvo encontrado com o nome: " + nomeJogo);
        } else {
            System.out.println("Jogo carregado: " + b.getNomeJogo());
        }
        return b;
    }

    /** Executa a próxima fase do jogo */
    public void executarProxFase() {
        if (faseAtualIndex >= fases.size()) {
            System.out.println("Todas as fases foram concluídas!");
            return;
        }

        Fase faseAtual = fases.get(faseAtualIndex);
        System.out.println("\n=== Iniciando Fase " + (faseAtualIndex + 1) + ": " + faseAtual.getNome() + " ===");

        faseAtual.executar(heroi);

        if (!heroi.estaVivo()) {
            System.out.println("\nO herói foi derrotado! Fim do jogo.");
            return;
        }

        faseAtualIndex++;
        System.out.println("Fase concluída! Fases restantes: " + (fases.size() - faseAtualIndex));

        // Salva progresso automaticamente
        GerenciadorDePersistencia.salvarBatalha(this, nomeJogo);
    }

    // -----------------------------
    // Getters e setters
    // -----------------------------

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public Personagem getHeroi() {
        return heroi;
    }

    public void setHeroi(Personagem heroi) {
        this.heroi = heroi;
    }

    public List<Fase> getFases() {
        return fases;
    }

    public void setFases(List<Fase> fases) {
        this.fases = fases;
    }

    public int getFaseAtualIndex() {
        return faseAtualIndex;
    }

    public void setFaseAtualIndex(int faseAtualIndex) {
        this.faseAtualIndex = faseAtualIndex;
    }

}
