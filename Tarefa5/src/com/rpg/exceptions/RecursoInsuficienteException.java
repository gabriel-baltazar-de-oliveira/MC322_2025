package com.rpg.exceptions;

/**
 * Exceção usada quando uma operação requer recursos específicos
 * que o jogador não possui em quantidade suficiente.
 * 
 * <p>Recursos podem incluir:
 * <ul>
 *   <li>Mana para lançar feitiços</li>
 *   <li>Energia para usar habilidades</li>
 *   <li>Ouro para comprar itens</li>
 *   <li>Materiais para crafting</li>
 * </ul>
 * 
 */
public class RecursoInsuficienteException extends Exception {
    
    /**
     * Cria uma nova exceção de recurso insuficiente com a mensagem especificada.
     *
     * @param mensagem Mensagem detalhando o recurso em falta e os requisitos
     */
    public RecursoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}