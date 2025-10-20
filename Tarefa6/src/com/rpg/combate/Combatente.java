package com.rpg.combate;

import com.rpg.personagens.Personagem;

/**
 * Interface que define um combatente no sistema de RPG.
 * 
 * <p>Atualizada para incluir todos os getters necessários para
 * que as ações de combate possam funcionar sem casting,
 * seguindo o princípio de agregação correta.</p>
 * 
 * @author RPG Development Team
 * @version 2.0
 */
public interface Combatente {
    
    /**
     * Retorna o nome do combatente.
     * 
     * @return Nome do combatente
     */
    String getNome();
    
    /**
     * Retorna a força do combatente para cálculo de dano.
     * 
     * @return Valor da força do combatente
     */
    int getForca();
    
    /**
     * Verifica se o combatente está vivo.
     * 
     * <p>Um combatente é considerado vivo se seus pontos de vida
     * são maiores que zero.</p>
     *
     * @return true se o combatente está vivo, false caso contrário
     */
    boolean estaVivo();
    
    /**
     * Realiza um ataque básico contra o alvo especificado.
     * 
     * <p>Este método deve implementar a lógica do ataque básico
     * do combatente, incluindo cálculo de dano e exibição de
     * mensagens descritivas.</p>
     *
     * @param alvo O personagem alvo do ataque
     */
    void atacar(Personagem alvo);
    
    /**
     * Utiliza a habilidade especial do combatente contra o alvo.
     * 
     * <p>Habilidades especiais geralmente causam mais dano que
     * ataques básicos ou possuem efeitos especiais. Cada classe
     * de combatente possui sua própria implementação única.</p>
     *
     * @param alvo O personagem alvo da habilidade especial
     */
    void usarHabilidadeEspecial(Personagem alvo);
    
    /**
     * Aplica dano ao combatente, reduzindo seus pontos de vida.
     * 
     * <p>Se os pontos de vida chegarem a zero ou menos, o combatente
     * deve ser considerado morto (estaVivo() retorna false).</p>
     *
     * @param dano Quantidade de dano a ser recebida
     */
    void receberDano(int dano);
    
    /**
     * Aplica cura ao combatente, restaurando pontos de vida.
     * 
     * <p>A cura não pode exceder a vida máxima do combatente.
     * Se o combatente estiver morto, a cura pode revivê-lo se
     * os pontos de vida se tornarem positivos.</p>
     *
     * @param cura Quantidade de pontos de vida a serem restaurados
     */
    void receberCura(int cura);
    
    /**
     * Escolhe uma ação de combate para executar contra o alvo.
     * 
     * <p>Este método é usado principalmente pela IA para decidir
     * qual ação um monstro deve tomar durante o combate. Para
     * heróis controlados pelo jogador, geralmente reflete a
     * escolha feita através da interface do usuário.</p>
     *
     * @param alvo O combatente alvo da ação
     * @return A ação de combate escolhida
     */
    AcaoDeCombate escolherAcao(Combatente alvo);
    
    /**
     * Retorna o dano físico base do combatente.
     * 
     * <p>Usado pelas ações de combate para calcular dano
     * sem necessidade de casting para classes específicas.</p>
     *
     * @return Valor do dano físico base
     */
    int getDanoFisico();
    
    /**
     * Retorna o dano mágico base do combatente.
     * 
     * <p>Usado por habilidades especiais para cálculo de dano
     * sem dependência de implementações específicas.</p>
     *
     * @return Valor do dano mágico base
     */
    int getDanoMagico();
    
    /**
     * Retorna a defesa do combatente.
     * 
     * @return Valor da defesa para cálculos de redução de dano
     */
    int getDefesa();
}