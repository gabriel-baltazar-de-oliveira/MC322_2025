package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.AcaoAtaqueBasico;
import java.util.Arrays;
import java.util.List;

/**
 * Classe que representa um herói controlado pelo jogador.
 * 
 * <p>Heróis são personagens jogáveis que possuem habilidades especiais
 * e podem evoluir ao longo do jogo. Esta classe serve como base para
 * heróis especializados: Paladino, Bruna e Arqueira, etc.</p>
 *
 */
public class Heroi extends Personagem {
    private final List<AcaoDeCombate> acoes;

    /**
     * Construtor para a classe Heroi.
     *
     * @param nome Nome do herói
     * @param vidaMaxima Pontos de vida máximos do herói
     * @param forca Força base do herói para cálculo de dano
     */
    public Heroi(String nome, int vidaMaxima, int forca) {
        super(nome, vidaMaxima, forca);
        this.acoes = Arrays.asList(new AcaoAtaqueBasico());
    }

    /**
     * Realiza um ataque básico contra o alvo.
     * 
     * <p>Utiliza a primeira ação disponível na lista de ações,
     * que normalmente é o ataque básico.</p>
     *
     * @param alvo O personagem alvo do ataque
     */
    @Override
    public void atacar(Personagem alvo) {
        acoes.get(0).executar(this, alvo);
    }

    /**
     * Utiliza a habilidade especial do herói contra o alvo.
     * 
     * <p>A habilidade especial causa dano adicional baseado na
     * força do herói. Subclasses podem sobrescrever este método
     * para implementar habilidades únicas.</p>
     *
     * @param alvo O personagem alvo da habilidade especial
     */
    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 10;
        alvo.receberDano(dano);
        System.out.println(getNome() + " usou habilidade especial em " + alvo.getNome() +
                           " causando dano de " + dano);
    }

    /**
     * Escolhe uma ação de combate para executar.
     * 
     * <p>Para heróis controlados pelo jogador, este método geralmente
     * reflete a escolha feita através do menu de combate. Nesta
     * implementação base, sempre retorna o ataque básico.</p>
     *
     * @param alvo O combatente alvo da ação
     * @return A ação de combate escolhida (ataque básico)
     */
    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        return acoes.get(0);
    }
}