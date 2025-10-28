package com.rpg.items;

/**
 * Interface base para todos os itens do sistema de RPG.
 * 
 * <p>Itens são objetos que podem ser coletados, equipados, usados
 * ou combinados pelo jogador. Esta interface define o contrato
 * mínimo que todos os itens devem seguir.</p>
 * 
 */
public interface Item {
    
    /**
     * Retorna o nome do item.
     * 
     * <p>O nome deve específico o suficiente para
     * que o jogador possa identificar facilmente o item.</p>
     *
     * @return Nome do item
     */
    String getNome();
}