package com.rpg.test.personagens;

import com.rpg.personagens.Monstro;
import com.rpg.personagens.Ciclope;
import com.rpg.personagens.ProfessorDaFEM;
import com.rpg.personagens.ElefantePsiquico;
import com.rpg.combate.Combatente;
import com.rpg.items.Item;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para as classes de Monstros
 * 
 * <p>Esta classe verifica que todos os monstros implementam corretamente
 * a interface Combatente, que o sistema de loot funciona e que
 * o comportamento de combate é adequado.</p>
 */
public class MonstroTest {

    /**
     * Testa se a classe Monstro implementa a interface Combatente
     * 
     * <p>Verifica que monstros podem ser tratados como Combatentes,
     * permitindo que participem do sistema de combate.</p>
     */
    @Test
    public void testMonstroImplementaCombatente() {
        Monstro monstro = new Ciclope();
        assertTrue(monstro instanceof Combatente, "Monstro deve implementar Combatente");
    }

    /**
     * Testa se todas as subclasses de monstro implementam Combatente
     * 
     * <p>Verifica a consistência na hierarquia de classes de monstros,
     * garantindo que todos possam participar de combates.</p>
     */
    @Test
    public void testSubclassesMonstroImplementamCombatente() {
        Ciclope ciclope = new Ciclope();
        ProfessorDaFEM professor = new ProfessorDaFEM();
        ElefantePsiquico elefante = new ElefantePsiquico();
        
        assertTrue(ciclope instanceof Combatente, "Ciclope deve implementar Combatente");
        assertTrue(professor instanceof Combatente, "ProfessorDaFEM deve implementar Combatente");
        assertTrue(elefante instanceof Combatente, "ElefantePsíquico deve implementar Combatente");
    }

    /**
     * Testa o recebimento de dano por um monstro
     * 
     * <p>Verifica que monstros respondem corretamente ao dano,
     * com redução de pontos de vida e atualização de estado.</p>
     */
    @Test
    public void testMonstroRecebeDano() {
        Monstro monstro = new Ciclope();
        int vidaInicial = monstro.getPontosDeVida();
        
        assertTrue(monstro.estaVivo(), "Monstro deve começar vivo");
        
        // Recebe dano parcial
        monstro.receberDano(50);
        assertEquals(vidaInicial - 50, monstro.getPontosDeVida(), 
                    "Pontos de vida devem ser reduzidos pelo dano");
        assertTrue(monstro.estaVivo(), "Monstro deve continuar vivo após dano parcial");
        
        // Recebe dano fatal
        monstro.receberDano(monstro.getPontosDeVida() + 100);
        assertEquals(0, monstro.getPontosDeVida(), "Pontos de vida devem ser 0 após dano fatal");
        assertFalse(monstro.estaVivo(), "Monstro deve estar morto após dano fatal");
    }

    /**
     * Testa o ataque de um monstro
     * 
     * <p>Verifica que monstros podem atacar e causar dano
     * baseado em sua força.</p>
     */
    @Test
    public void testMonstroAtacaAlvo() {
        Monstro monstro = new ProfessorDaFEM();
        Heroi alvo = new Heroi("Alvo Herói", 100, 15);
        
        int vidaInicialAlvo = alvo.getPontosDeVida();
        monstro.atacar(alvo);
        
        assertTrue(alvo.getPontosDeVida() < vidaInicialAlvo, "Alvo deve receber dano do monstro");
    }

    /**
     * Testa que monstros são "lootáveis"
     * 
     * <p>Verifica que monstros podem dropar itens quando derrotados,
     * implementando o sistema de recompensas do jogo.</p>
     */
    @Test
    public void testMonstroELootavel() {
        Monstro monstro = new ElefantePsiquico();
        
        // Testa que monstro pode dropar loot
        Item loot = monstro.droparLoot();
        assertNotNull(loot, "Monstro deve dropar um item não nulo");
        assertNotNull(loot.getNome(), "Item drogado deve ter um nome");
    }

    /**
     * Testa a experiência concedida por monstros
     * 
     * <p>Verifica que cada monstro concede uma quantidade específica
     * de experiência quando derrotado.</p>
     */
    @Test
    public void testMonstroConcedeExperiencia() {
        Ciclope ciclope = new Ciclope();
        ProfessorDaFEM professor = new ProfessorDaFEM();
        ElefantePsiquico elefante = new ElefantePsiquico();
        
        assertTrue(ciclope.getXpConcedido() > 0, "Ciclope deve conceder experiência positiva");
        assertTrue(professor.getXpConcedido() > 0, "ProfessorDaFEM deve conceder experiência positiva");
        assertTrue(elefante.getXpConcedido() > 0, "ElefantePsíquico deve conceder experiência positiva");
        
        // Verifica diferenças de XP entre monstros (balanceamento)
        assertTrue(ciclope.getXpConcedido() != professor.getXpConcedido() ||
                  professor.getXpConcedido() != elefante.getXpConcedido(),
                  "Diferentes monstros devem conceder quantidades diferentes de XP");
    }

    /**
     * Testa a habilidade especial de monstros
     * 
     * <p>Verifica que monstros possuem habilidades especiais
     * que causam mais dano que ataques básicos.</p>
     */
    @Test
    public void testMonstroHabilidadeEspecial() {
        Monstro monstro = new Ciclope();
        Heroi alvo = new Heroi("Alvo", 200, 10);
        
        int vidaInicialAlvo = alvo.getPontosDeVida();
        monstro.usarHabilidadeEspecial(alvo);
        
        // Habilidade especial causa dano significativo
        assertTrue(alvo.getPontosDeVida() < vidaInicialAlvo - monstro.getForca(),
                  "Habilidade especial deve causar mais dano que ataque básico");
    }
}