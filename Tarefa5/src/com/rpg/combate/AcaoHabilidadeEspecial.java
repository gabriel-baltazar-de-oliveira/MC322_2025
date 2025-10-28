package com.rpg.combate;

/**
 * Implementação de ação de combate para habilidades especiais.
 * 
 * <p>Esta classe representa habilidades especiais que causam dano
 * adicional baseado em um multiplicador. Diferentes personagens
 * podem ter habilidades especiais com nomes e multiplicadores
 * específicos.</p>
 * 
 */
public class AcaoHabilidadeEspecial implements AcaoDeCombate {
    private final int multiplicador;
    private final String nomeHabilidade;

    /**
     * Construtor para ação de habilidade especial.
     *
     * @param nomeHabilidade Nome descritivo da habilidade especial
     * @param multiplicador Multiplicador de dano adicional da habilidade
     */
    public AcaoHabilidadeEspecial(String nomeHabilidade, int multiplicador) {
        this.nomeHabilidade = nomeHabilidade;
        this.multiplicador = multiplicador;
    }

    /**
     * Executa a habilidade especial do usuário contra o alvo.
     * 
     * <p>O dano causado é calculado como a força do usuário mais
     * o multiplicador da habilidade. Uma mensagem é
     * exibida mostrando o nome da habilidade e o dano causado.</p>
     *
     * @param usuario O combatente usando a habilidade especial
     * @param alvo O combatente recebendo a habilidade especial
     * @throws NullPointerException Se usuario ou alvo forem nulos
     */
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int dano = usuario.getForca() + multiplicador;
        alvo.receberDano(dano);
        System.out.println(usuario.getNome() + " usa " + nomeHabilidade + " causando dano de " + dano + " em " + alvo.getNome());
    }
}