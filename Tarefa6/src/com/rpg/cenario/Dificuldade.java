package com.rpg.cenario;

/**
 * Enumeração para definir os níveis de dificuldade do RPG.
 *
 * <p>Cada nível de dificuldade possui coeficientes específicos que
 * afetam vida força dos monstros, tornando o jogo mais dificultado
 * nos níveis mais altos. O sistema de dificuldade é aplicado durante
 * a geração de fases para ajustar o desafio de acordo com a
 * escolha do jogador.</p>
 *
 */
public enum Dificuldade {
    /**
     * Dificuldade fácil - recomendada para jogadores iniciantes.
     * Monstros têm 70% da vida e 80% da força normais.
     */
    FACIL(0.7, 0.8, "Fácil"),

    /**
     * Dificuldade média - padrão do jogo.
     * Monstros têm valores normais d vida e força.
     */
    MEDIA(1.0, 1.0, "Média"),

    /**
     * Dificuldade difícil - para jogadores avançados.
     * Monstros têm 130% da vida e 120% da força normais.
     */
    DIFICIL(1.3, 1.2, "Difícil");

    private final double multiplicadorVida;
    private final double multiplicadorForca;
    private final String descricao;

    /**
     * Construtor para os níveis de dificuldade.
     *
     * @param multiplicadorVida é coeficiente para a vida dos monstros
     * @param multiplicadorForca é coeficiente para força dos monstros
     * @param descricao descrição do nível de dificuldade
     */
    Dificuldade(double multiplicadorVida, double multiplicadorForca, String descricao) {
        this.multiplicadorVida = multiplicadorVida;
        this.multiplicadorForca = multiplicadorForca;
        this.descricao = descricao;
    }

    /**
     * Retorna o coeficiente de pontos de vida para a dificuldade.
     *
     * @return coeficiente a ser aplicado na vida dos monstros
     */
    public double getMultiplicadorVida() {
        return multiplicadorVida;
    }

    /**
     * Retorna o coeficiente de força para esta dificuldade.
     *
     * @return coeficiente a ser aplicado na força dos monstros
     */
    public double getMultiplicadorForca() {
        return multiplicadorForca;
    }

    /**
     * Retorna a descrição do nível de dificuldade.
     *
     * @return Descrição do nível de dificuldade para mostrar ao usuário
     */
    public String getDescricao() {
        return descricao;
    }
}