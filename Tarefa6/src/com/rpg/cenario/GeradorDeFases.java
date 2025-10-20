package com.rpg.cenario;

import java.util.List;

/**
 * Interface para geradores de fases do jogo.
 * 
 * <p>Esta interface define o contrato para classes que geram sequências
 * de fases para o jogador. Diferentes implementações podem criar fases
 * pré-definidas, aleatórias, ou baseadas em progressão do jogador.</p>
 * 
 */
public interface GeradorDeFases {
    
    /**
     * Gera uma lista de fases para o jogo.
     * 
     * <p>O gerador cria uma sequência de fases de acordo com a quantidade
     * solicitada e aplica a dificuldade especificada para balancear
     * o desafio. Cada fase pode conter combates, eventos especiais,
     * ou outros desafios para o jogador.</p>
     *
     * @param quantidadeDeFases Número de fases a serem geradas
     * @param dificuldade Nível de dificuldade a ser aplicado nas fases
     * @return Lista de fases geradas, na ordem em que devem ser jogadas
     */
    List<Fase> gerar(int quantidadeDeFases, Dificuldade dificuldade);
}