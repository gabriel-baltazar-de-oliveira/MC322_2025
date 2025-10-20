package com.rpg.game;

import com.rpg.cenario.Dificuldade;
import com.rpg.util.InputManager;

/**
 * Gerenciador principal do jogo - versão final para Tarefa 6.
 * 
 * <p>Coordena a execução de batalhas tanto novas quanto carregadas,
 * integrando todos os sistemas implementados.</p>
 * 
 * @author RPG Development Team
 * @version 3.0
 */
public class GerenciadorJogo {

    /**
     * Inicia um novo jogo com a dificuldade especificada.
     * 
     * @param dificuldade Nível de dificuldade do jogo
     */
    public static void iniciarJogo(Dificuldade dificuldade) {
        System.out.println("\n Iniciando Nova Aventura...");
        System.out.println("Dificuldade: " + dificuldade.getDescricao());
        
        Batalha batalha = new Batalha(dificuldade);
        executarBatalha(batalha);
    }
    
    /**
     * Executa uma batalha carregada.
     * 
     * @param batalha Batalha carregada para execução
     */
    public static void executarBatalhaCarregada(Batalha batalha) {
        System.out.println("\n🔄 Continuando Aventura...");
        System.out.println("Progresso: Fase " + (batalha.getFaseAtual() + 1));
        
        executarBatalha(batalha);
    }
    
    /**
     * Executa o loop principal de uma batalha.
     * 
     * @param batalha Batalha a ser executada
     */
    private static void executarBatalha(Batalha batalha) {
        // Executa todas as fases sequencialmente
        while (batalha.isJogoAtivo() && batalha.getFaseAtual() < batalha.getFases().size()) {
            batalha.executarProxFase();
        }
        
        // Mensagem final baseada no resultado
        if (batalha.getHeroi().estaVivo()) {
            System.out.println("\nParabéns! Você completou sua aventura!");
        } else {
            System.out.println("\nSua aventura chegou ao fim...");
        }
        
        System.out.println("\n=== VOLTANDO AO MENU PRINCIPAL ===");
        InputManager.esperarEnter("Pressione ENTER para continuar...");
    }
}