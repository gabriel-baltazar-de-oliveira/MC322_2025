package com.rpg.combate;

/**
 * Interface que define uma ação de combate no sistema de RPG.
 * 
 * <p>Esta interface representa uma ação que pode ser executada durante um combate,
 * como ataques básicos, habilidades especiais, defesas, ou uso de itens.
 * O padrão Strategy é aplicado aqui para permitir diferentes comportamentos
 * de combate sem modificar as classes dos combatentes.</p>
 * 
 */
public interface AcaoDeCombate {
    
    /**
     * Executa a ação de combate entre um usuário e um alvo.
     * 
     * <p>Este método é responsável por implementar a lógica específica da ação,
     * incluindo cálculo de dano, efeitos especiais, e exibição de mensagens
     * descritivas do que ocorreu durante a ação.</p>
     *
     * @param usuario O combatente que está executando a ação
     * @param alvo O combatente que está recebendo a ação
     * @throws NullPointerException Se usuario ou alvo forem nulos
     */
    void executar(Combatente usuario, Combatente alvo);
}