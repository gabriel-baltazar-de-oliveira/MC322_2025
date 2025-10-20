package com.rpg.combate;

/**
 * Implementação de ação de combate para habilidades especiais.
 * 
 * <p>Atualizada para funcionar com qualquer Combatente através
 * dos métodos padronizados da interface.</p>
 * 
 * @author RPG Development Team
 * @version 2.0
 */
public class AcaoHabilidadeEspecial implements AcaoDeCombate {
    private final int bonusDano;
    private final String nomeHabilidade;

    public AcaoHabilidadeEspecial(String nomeHabilidade, int bonusDano) {
        this.nomeHabilidade = nomeHabilidade;
        this.bonusDano = bonusDano;
    }

    /**
     * Executa a habilidade especial do usuário contra o alvo.
     * 
     * <p>Usa getDanoMagico() para cálculo base, permitindo que
     * diferentes tipos de combatentes tenham comportamentos
     * específicos sem necessidade de casting.</p>
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int danoBase = usuario.getDanoMagico();
        int defesaAlvo = alvo.getDefesa();
        
        // Habilidades especiais ignoram parte da defesa
        int danoFinal = Math.max(1, danoBase + bonusDano - (defesaAlvo / 4));
        
        alvo.receberDano(danoFinal);
        System.out.println(usuario.getNome() + " usa " + nomeHabilidade + 
                          " causando " + danoFinal + " de dano em " + alvo.getNome());
    }
}