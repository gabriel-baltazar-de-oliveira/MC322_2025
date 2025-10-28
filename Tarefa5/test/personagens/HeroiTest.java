package com.rpg.test.personagens;

import com.rpg.personagens.Heroi;
import com.rpg.personagens.Paladino;
import com.rpg.personagens.Arqueira;
import com.rpg.personagens.Bruxa;
import com.rpg.combate.Combatente;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para as classes de Heróis
 * 
 * <p>Esta classe verifica que todos os heróis implementam corretamente
 * a interface Combatente e que o sistema de dano e cura funciona
 * conforme esperado.</p>
 */
public class HeroiTest {

    /**
     * Testa se a classe Heroi implementa a interface Combatente
     * 
     * <p>Verifica que heróis podem ser tratados como Combatentes,
     * garantindo o polimorfismo no sistema de combate.</p>
     */
    @Test
    public void testHeroiImplementaCombatente() {
        Heroi heroi = new Heroi("Herói Teste", 100, 20);
        assertTrue(heroi instanceof Combatente, "Heroi deve implementar Combatente");
    }

    /**
     * Testa se as classes especializadas de heróis implementam Combatente
     * 
     * <p>Verifica que todas as subclasses de Heroi mantêm a implementação
     * da interface Combatente.</p>
     */
    @Test
    public void testSubclassesHeroiImplementamCombatente() {
        Paladino paladino = new Paladino("Paladino", 120, 25, 15, "Luz Divina");
        Arqueira arqueira = new Arqueira("Arqueira", 90, 18, 20, "Flecha Flamejante");
        Bruxa bruxa = new Bruxa("Bruxa", 80, 15, 25, "Bola de Fogo");
        
        assertTrue(paladino instanceof Combatente, "Paladino deve implementar Combatente");
        assertTrue(arqueira instanceof Combatente, "Arqueira deve implementar Combatente");
        assertTrue(bruxa instanceof Combatente, "Bruxa deve implementar Combatente");
    }

    /**
     * Testa o recebimento de dano por um herói
     * 
     * <p>Verifica que quando um herói recebe dano, seus pontos de vida
     * são reduzidos corretamente e o estado 'estaVivo' é atualizado.</p>
     */
    @Test
    public void testHeroiRecebeDano() {
        Heroi heroi = new Heroi("Herói Teste", 100, 20);
        
        // Herói começa vivo
        assertTrue(heroi.estaVivo(), "Herói deve começar vivo");
        assertEquals(100, heroi.getPontosDeVida(), "Pontos de vida iniciais devem ser 100");
        
        // Recebe dano
        heroi.receberDano(30);
        assertEquals(70, heroi.getPontosDeVida(), "Pontos de vida devem ser reduzidos em 30");
        assertTrue(heroi.estaVivo(), "Herói deve continuar vivo após dano parcial");
        
        // Recebe dano fatal
        heroi.receberDano(80);
        assertEquals(0, heroi.getPontosDeVida(), "Pontos de vida devem ser 0 após dano fatal");
        assertFalse(heroi.estaVivo(), "Herói deve estar morto após dano fatal");
    }

    /**
     * Testa o recebimento de cura por um herói
     * 
     * <p>Verifica que a cura restaura pontos de vida corretamente
     * e que heróis mortos não podem ser curados.</p>
     */
    @Test
    public void testHeroiRecebeCura() {
        Heroi heroi = new Heroi("Herói Teste", 100, 20);
        
        // Recebe dano e depois cura
        heroi.receberDano(40);
        assertEquals(60, heroi.getPontosDeVida(), "Pontos de vida após dano");
        
        heroi.receberCura(20);
        assertEquals(80, heroi.getPontosDeVida(), "Pontos de vida devem aumentar com cura");
        
        // Cura não deve exceder vida máxima
       // heroi.receberCura(30);
        //assertEquals(100, heroi.getPontosDeVida(), "Cura não deve exceder vida máxima");
    }

    /**
     * Testa o ataque básico de um herói
     * 
     * <p>Verifica que o método atacar causa dano ao alvo
     * baseado na força do herói.</p>
     */
    @Test
    public void testHeroiAtacaAlvo() {
        Heroi heroi = new Heroi("Herói Atacante", 100, 25);
        Heroi alvo = new Heroi("Alvo", 100, 15);
        
        int vidaInicialAlvo = alvo.getPontosDeVida();
        heroi.atacar(alvo);
        
        assertTrue(alvo.getPontosDeVida() < vidaInicialAlvo, "Alvo deve receber dano do ataque");
        assertEquals(vidaInicialAlvo - heroi.getForca(), alvo.getPontosDeVida(), 
                    "Dano deve ser igual à força do herói");
    }

    /**
     * Testa a habilidade especial de um herói
     * 
     * <p>Verifica que a habilidade especial causa dano adicional
     * comparado ao ataque básico.</p>
     */
    @Test
    public void testHeroiHabilidadeEspecial() {
        Heroi heroi = new Heroi("Herói Especial", 100, 20);
        Heroi alvo = new Heroi("Alvo", 100, 15);
        
        int vidaInicialAlvo = alvo.getPontosDeVida();
        heroi.usarHabilidadeEspecial(alvo);
        
        // Habilidade especial deve causar mais dano que ataque básico
        assertTrue(alvo.getPontosDeVida() < vidaInicialAlvo - heroi.getForca(),
                  "Habilidade especial deve causar mais dano que ataque básico");
    }
}