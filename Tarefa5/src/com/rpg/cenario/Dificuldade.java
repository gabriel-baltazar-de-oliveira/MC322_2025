package com.rpg.cenario;

/**
 * Enumeração que define os níveis de dificuldade do jogo.
 * 
 * <p>Cada nível de dificuldade possui multiplicadores específicos que
 * afetam a vida e força dos monstros, tornando o jogo mais desafiador
 * em níveis mais altos. O sistema de dificuldade é aplicado durante
 * a geração de fases para balancear o desafio de acordo com a
 * preferência do jogador.</p>
 *
 */
public enum Dificuldade {
    /**
     * Dificuldade fácil - para jogadores iniciantes.
     * Monstros possuem 70% da vida e 80% da força normais.
     */
    FACIL(0.7, 0.8, "Fácil"),
    
    /**
     * Dificuldade média - balance padrão do jogo.
     * Monstros possuem valores normais de vida e força.
     */
    MEDIA(1.0, 1.0, "Média"),
    
    /**
     * Dificuldade difícil - para jogadores experientes.
     * Monstros possuem 130% da vida e 120% da força normais.
     */
    DIFICIL(1.3, 1.2, "Difícil");

    private final double multiplicadorVida;
    private final double multiplicadorForca;
    private final String descricao;

    /**
     * Construtor para os níveis de dificuldade.
     *
     * @param multiplicadorVida Multiplicador para pontos de vida dos monstros
     * @param multiplicadorForca Multiplicador para força dos monstros  
     * @param descricao Descrição amigável do nível de dificuldade
     */
    Dificuldade(double multiplicadorVida, double multiplicadorForca, String descricao) {
        this.multiplicadorVida = multiplicadorVida;
        this.multiplicadorForca = multiplicadorForca;
        this.descricao = descricao;
    }

    /**
     * Retorna o multiplicador de pontos de vida para esta dificuldade.
     * 
     * @return Multiplicador a ser aplicado nos pontos de vida dos monstros
     */
    public double getMultiplicadorVida() {
        return multiplicadorVida;
    }

    /**
     * Retorna o multiplicador de força para esta dificuldade.
     * 
     * @return Multiplicador a ser aplicado na força dos monstros
     */
    public double getMultiplicadorForca() {
        return multiplicadorForca;
    }

    /**
     * Retorna a descrição amigável do nível de dificuldade.
     * 
     * @return Descrição do nível de dificuldade para exibição ao usuário
     */
    public String getDescricao() {
        return descricao;
    }
}