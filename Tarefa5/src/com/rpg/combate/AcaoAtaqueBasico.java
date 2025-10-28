package com.rpg.combate;

/**
 * Implementação concreta de ação de combate para ataques básicos.
 * 
 * <p>Esta classe representa o ataque básico padrão que todos os combatentes
 * podem realizar. O dano causado é baseado diretamente na força do usuário,
 * sem modificadores ou efeitos especiais.</p>
 * 
 * @see AcaoDeCombate
 */
public class AcaoAtaqueBasico implements AcaoDeCombate {
    
    /**
     * Executa um ataque básico do usuário contra o alvo.
     * 
     * <p>O dano causado é igual à força do usuário. Após o cálculo do dano,
     * uma mensagem é exibida no console informando o resultado
     * do ataque.</p>
     *
     * @param usuario O combatente realizando o ataque
     * @param alvo O combatente recebendo o ataque
     * @throws NullPointerException Se usuario ou alvo forem nulos
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int dano = usuario.getForca();
        alvo.receberDano(dano);
        System.out.println(usuario.getNome() + " ataca " + alvo.getNome() + " causando dano de " + dano);
    }
}