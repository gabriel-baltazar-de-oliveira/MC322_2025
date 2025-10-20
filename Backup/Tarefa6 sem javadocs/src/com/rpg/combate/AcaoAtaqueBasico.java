package com.rpg.combate;

/**
 * Implementação concreta de ação de combate para ataques básicos.
 * 
 * <p>Atualizada para usar os métodos padronizados da interface Combatente
 * em vez de acessar campos específicos, permitindo reuso sem casting.</p>
 * 
 * @author RPG Development Team
 * @version 2.0
 * @see AcaoDeCombate
 */
public class AcaoAtaqueBasico implements AcaoDeCombate {
    
    /**
     * Executa um ataque básico do usuário contra o alvo.
     * 
     * <p>O dano é calculado usando getDanoFisico() da interface Combatente,
     * permitindo que qualquer implementação de Combatente funcione
     * sem necessidade de casting.</p>
     *
     * @param usuario O combatente realizando o ataque
     * @param alvo O combatente recebendo o ataque
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int danoBase = usuario.getDanoFisico();
        int defesaAlvo = alvo.getDefesa();
        
        // Cálculo simples de dano considerando defesa
        int danoFinal = Math.max(1, danoBase - (defesaAlvo / 2));
        
        alvo.receberDano(danoFinal);
        System.out.println(usuario.getNome() + " ataca " + alvo.getNome() + 
                          " causando " + danoFinal + " de dano!");
    }
}