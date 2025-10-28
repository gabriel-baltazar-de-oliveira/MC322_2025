package com.rpg.exceptions;

/**
 * Exceção usada quando uma operação requer um nível específico
 * que o jogador não possui.
 * 
 * <p>Esta exceção é usada em situações como:
 * <ul>
 *   <li>Equipar itens com requisito de nível</li>
 *   <li>Aprender habilidades com nível mínimo</li>
 *   <li>Acessar áreas restritas por nível</li>
 * </ul>
 * 
 */
public class NivelInsuficienteException extends Exception {
    
    /**
     * Cria uma nova exceção de nível insuficiente com a mensagem especificada.
     *
     * @param mensagem Mensagem detalhando o requisito de nível não atendido
     */
    public NivelInsuficienteException(String mensagem) {
        super(mensagem);
    }
}