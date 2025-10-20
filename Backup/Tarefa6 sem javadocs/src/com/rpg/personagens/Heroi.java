package com.rpg.personagens;

import com.rpg.combate.AcaoDeCombate;
import com.rpg.combate.Combatente;
import com.rpg.combate.GerenciadorAcoesCombate;
import com.rpg.items.Item;

/**
 * Classe que representa um herói controlado pelo jogador.
 *
 * @author RPG Development Team
 * @version 2.2
 */
public class Heroi extends Personagem {

    public Heroi(String nome, int vidaMaxima, int forca) {
        super(nome, vidaMaxima, forca);
    }

    /**
     * Construtor padrão necessário para serialização (Jackson).
     */
    public Heroi() {
        super("", 0, 0);
    }

    @Override
    public void atacar(Personagem alvo) {
        GerenciadorAcoesCombate.getAcao("ATAQUE_BASICO").executar(this, alvo);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 10;
        alvo.receberDano(dano);
        System.out.println(getNome() + " usou habilidade especial em " + alvo.getNome() +
                           " causando dano de " + dano);
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // Em uma implementação completa, isso viria do input do usuário
        return GerenciadorAcoesCombate.getAcao("ATAQUE_BASICO");
    }

    /**
     * Exibe as informações atuais do herói no console.
     */
    public void exibirInfo() {
        System.out.println("Nome: " + getNome());
        System.out.println("Vida: " + getPontosDeVida() + " / " + getVidaMaxima());
        System.out.println("Força: " + getForca());
        System.out.println("Status: " + (estaVivo() ? "Vivo" : "Morto"));
    }

    /**
     * Equipa um item, aplicando seus bônus aos atributos do herói.
     * @param itemEscolhido O item a ser equipado.
     */
    public void equiparItem(Item itemEscolhido) {
        if (itemEscolhido == null) {
            System.out.println("Item inválido.");
            return;
        }

        System.out.println(getNome() + " equipou " + itemEscolhido.getNome() + ".");

        int bonusForca = itemEscolhido.getBonusForca();
        int bonusVida = itemEscolhido.getBonusVida();

        if (bonusForca > 0) {
            this.setForca(this.getForca() + bonusForca);
            System.out.println("Força aumentada em " + bonusForca + "! Nova força: " + this.getForca());
        }

        if (bonusVida > 0) {
            this.setVidaMaxima(this.getVidaMaxima() + bonusVida);
            this.receberCura(bonusVida);
            System.out.println("Vida máxima aumentada em " + bonusVida + "! Vida atual: " + this.getPontosDeVida());
        }
    }

    // --- MÉTODOS DA INTERFACE COMBATENTE QUE ESTAVAM FALTANDO ---

    @Override
    public int getDanoFisico() {
        // O dano físico base do herói é a sua força.
        return this.getForca();
    }

    @Override
    public int getDanoMagico() {
        // Por enquanto, nosso herói não tem dano mágico.
        return 0;
    }

    @Override
    public int getDefesa() {
        // Vamos dar ao herói uma defesa base de 5.
        // No futuro, isso poderia ser um atributo em Personagem.
        return 5;
    }

} // <-- CHAVE FINAL QUE ESTAVA FALTANDO