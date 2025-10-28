package com.rpg.cenario;

import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;

/**
 * Interface que define uma fase no sistema de RPG.
 * 
 * <p>Uma fase representa um segmento jogável do jogo que pode conter
 * combates, quebra-cabeças, exploração ou outros desafios. Cada fase
 * deve ser capaz de ser iniciada, verificada se foi concluída, e
 * fornecer informações sobre seu conteúdo.</p>
 *
 */
public interface Fase {
    
    /**
     * Inicia a fase para o herói escolhido.
     * 
     * <p>Este método é chamado quando a fase começa e configura
     * o ambiente, aplica efeitos de cenário, e prepara os desafios
     * para o herói.</p>
     *
     * @param heroi O herói que está iniciando a fase
     */
    void iniciar(Heroi heroi);
    
    /**
     * Verifica se a fase foi concluída com sucesso.
     * 
     * <p>Uma fase é considerada concluída quando todos os objetivos
     * foram atingidos, neste caso, derrotar todos os monstros.</p>
     *
     * @return true se a fase foi concluída, false caso contrário
     */
    boolean isConcluida();
    
    /**
     * Retorna o tipo de cenário da fase.
     * 
     * @return Nome do tipo de cenário (ex: "BAR", "FACULDADE", "CASTELO")
     */
    String getTipoDeCenario();
    
    /**
     * Retorna a descrição do cenário da fase.
     * 
     * @return Descrição do cenário
     */
    String getDescricion();
    
    /**
     * Retorna a lista de monstros da fase.
     * 
     * <p>Para fases de combate, esta lista contém todos os monstros
     * que devem ser derrotados.</p>
     *
     * @return Lista de monstros na fase
     */
    java.util.List<Monstro> getMonstros();
}