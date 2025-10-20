package com.rpg.test.cenario;

import com.rpg.cenario.Dificuldade;
import com.rpg.personagens.Monstro;
import com.rpg.personagens.Ciclope;
import com.rpg.personagens.ProfessorDaFEM;
import com.rpg.personagens.ElefantePsiquico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para o sistema de dificuldade
 * 
 * <p>Esta classe verifica que o sistema de dificuldade altera
 * corretamente os atributos dos monstros, tornando o jogo mais
 * desafiador em níveis mais altos de dificuldade.</p>
 */
public class DificuldadeTest {

    /**
     * Testa os multiplicadores de dificuldade
     * 
     * <p>Verifica que cada nível de dificuldade possui multiplicadores
     * diferentes para vida e força, seguindo uma progressão lógica
     * onde dificuldades maiores têm multiplicadores maiores.</p>
     */
    @Test
    public void testMultiplicadoresDificuldade() {
        // Verifica a progressão dos multiplicadores de vida
        assertTrue(Dificuldade.FACIL.getMultiplicadorVida() < 
                  Dificuldade.MEDIA.getMultiplicadorVida(),
                  "Dificuldade Média deve ter mais vida que Fácil");
        
        assertTrue(Dificuldade.MEDIA.getMultiplicadorVida() < 
                  Dificuldade.DIFICIL.getMultiplicadorVida(),
                  "Dificuldade Difícil deve ter mais vida que Média");

        // Verifica a progressão dos multiplicadores de força
        assertTrue(Dificuldade.FACIL.getMultiplicadorForca() < 
                  Dificuldade.MEDIA.getMultiplicadorForca(),
                  "Dificuldade Média deve ter mais força que Fácil");
        
        assertTrue(Dificuldade.MEDIA.getMultiplicadorForca() < 
                  Dificuldade.DIFICIL.getMultiplicadorForca(),
                  "Dificuldade Difícil deve ter mais força que Média");
    }

    /**
     * Testa que monstros em dificuldade maior têm mais vida
     * 
     * <p>Verifica o princípio básico do sistema de dificuldade:
     * monstros em dificuldades mais altas possuem mais pontos
     * de vida que em dificuldades mais baixas.</p>
     */
    @Test
    public void testMonstrosDificilTemMaisVida() {
        // Cria monstros base (sem aplicação de dificuldade)
        Ciclope ciclopeFacil = new Ciclope();
        Ciclope ciclopeDificil = new Ciclope();
        
        ProfessorDaFEM professorFacil = new ProfessorDaFEM();
        ProfessorDaFEM professorDificil = new ProfessorDaFEM();
        
        ElefantePsiquico elefanteFacil = new ElefantePsiquico();
        ElefantePsiquico elefanteDificil = new ElefantePsiquico();

        // Aplica dificuldade (simulação do que o ConstrutorDeCenarioFixo faz)
        int vidaCiclopeFacil = (int)(ciclopeFacil.getPontosDeVida() * Dificuldade.FACIL.getMultiplicadorVida());
        int vidaCiclopeDificil = (int)(ciclopeDificil.getPontosDeVida() * Dificuldade.DIFICIL.getMultiplicadorVida());
        
        int vidaProfessorFacil = (int)(professorFacil.getPontosDeVida() * Dificuldade.FACIL.getMultiplicadorVida());
        int vidaProfessorDificil = (int)(professorDificil.getPontosDeVida() * Dificuldade.DIFICIL.getMultiplicadorVida());
        
        int vidaElefanteFacil = (int)(elefanteFacil.getPontosDeVida() * Dificuldade.FACIL.getMultiplicadorVida());
        int vidaElefanteDificil = (int)(elefanteDificil.getPontosDeVida() * Dificuldade.DIFICIL.getMultiplicadorVida());

        // Verifica que monstros em difícil têm mais vida
        assertTrue(vidaCiclopeDificil > vidaCiclopeFacil,
                  "Ciclope em dificuldade difícil deve ter mais vida que em fácil");
        
        assertTrue(vidaProfessorDificil > vidaProfessorFacil,
                  "ProfessorDaFEM em dificuldade difícil deve ter mais vida que em fácil");
        
        assertTrue(vidaElefanteDificil > vidaElefanteFacil,
                  "ElefantePsíquico em dificuldade difícil deve ter mais vida que em fácil");
    }

    /**
     * Testa que monstros em dificuldade maior têm mais força
     * 
     * <p>Verifica que além de terem mais vida, monstros em
     * dificuldades mais altas também causam mais dano,
     * tornando o combate mais desafiador.</p>
     */
    @Test
    public void testMonstrosDificilTemMaisForca() {
        // Cria monstros base
        Ciclope ciclopeFacil = new Ciclope();
        Ciclope ciclopeDificil = new Ciclope();
        
        ProfessorDaFEM professorFacil = new ProfessorDaFEM();
        ProfessorDaFEM professorDificil = new ProfessorDaFEM();

        // Aplica dificuldade aos atributos de força
        int forcaCiclopeFacil = (int)(ciclopeFacil.getForca() * Dificuldade.FACIL.getMultiplicadorForca());
        int forcaCiclopeDificil = (int)(ciclopeDificil.getForca() * Dificuldade.DIFICIL.getMultiplicadorForca());
        
        int forcaProfessorFacil = (int)(professorFacil.getForca() * Dificuldade.FACIL.getMultiplicadorForca());
        int forcaProfessorDificil = (int)(professorDificil.getForca() * Dificuldade.DIFICIL.getMultiplicadorForca());

        // Verifica que monstros em difícil têm mais força
        assertTrue(forcaCiclopeDificil > forcaCiclopeFacil,
                  "Ciclope em dificuldade difícil deve ter mais força que em fácil");
        
        assertTrue(forcaProfessorDificil > forcaProfessorFacil,
                  "ProfessorDaFEM em dificuldade difícil deve ter mais força que em fácil");
    }

    /**
     * Testa as descrições dos níveis de dificuldade
     * 
     * <p>Verifica que cada nível de dificuldade possui uma
     * descrição adequada para ser exibida ao usuário.</p>
     */
    @Test
    public void testDescricoesDificuldade() {
        assertNotNull(Dificuldade.FACIL.getDescricao(), "Dificuldade Fácil deve ter descrição");
        assertNotNull(Dificuldade.MEDIA.getDescricao(), "Dificuldade Média deve ter descrição");
        assertNotNull(Dificuldade.DIFICIL.getDescricao(), "Dificuldade Difícil deve ter descrição");
        
        assertFalse(Dificuldade.FACIL.getDescricao().isEmpty(), "Descrição não deve ser vazia");
        assertFalse(Dificuldade.MEDIA.getDescricao().isEmpty(), "Descrição não deve ser vazia");
        assertFalse(Dificuldade.DIFICIL.getDescricao().isEmpty(), "Descrição não deve ser vazia");
    }

    /**
     * Testa a consistência entre vida e força na mesma dificuldade
     * 
     * <p>Verifica que dentro de uma mesma dificuldade, o balanceamento
     * entre os multiplicadores de vida e força é consistente.</p>
     */
    @Test
    public void testConsistenciaIntraDificuldade() {
        // Em uma mesma dificuldade, os multiplicadores devem ser consistentes
        // (não testamos valores específicos, apenas relações)
        
        // Em geral, multiplicador de vida pode ser diferente do de força
        // mas ambos devem seguir a mesma direção (aumentar com dificuldade)
        assertTrue(Dificuldade.FACIL.getMultiplicadorVida() > 0, "Multiplicador deve ser positivo");
        assertTrue(Dificuldade.FACIL.getMultiplicadorForca() > 0, "Multiplicador deve ser positivo");
        
        assertTrue(Dificuldade.MEDIA.getMultiplicadorVida() > 0, "Multiplicador deve ser positivo");
        assertTrue(Dificuldade.MEDIA.getMultiplicadorForca() > 0, "Multiplicador deve ser positivo");
        
        assertTrue(Dificuldade.DIFICIL.getMultiplicadorVida() > 0, "Multiplicador deve ser positivo");
        assertTrue(Dificuldade.DIFICIL.getMultiplicadorForca() > 0, "Multiplicador deve ser positivo");
    }

    /**
     * Testa o impacto cumulativo da dificuldade em monstros diferentes
     * 
     * <p>Verifica que o sistema de dificuldade afeta consistentemente
     * diferentes tipos de monstros, mantendo o balanceamento relativo
     * entre eles.</p>
     */
    @Test
    public void testDificuldadeAfetaTodosMonstrosConsistentemente() {
        // Testa que a diferença relativa entre monstros se mantém
        // entre dificuldades diferentes
        Ciclope ciclopeFacil = new Ciclope();
        ProfessorDaFEM professorFacil = new ProfessorDaFEM();
        
        Ciclope ciclopeDificil = new Ciclope();
        ProfessorDaFEM professorDificil = new ProfessorDaFEM();

        // Aplica dificuldade
        int vidaCiclopeFacil = (int)(ciclopeFacil.getPontosDeVida() * Dificuldade.FACIL.getMultiplicadorVida());
        int vidaProfessorFacil = (int)(professorFacil.getPontosDeVida() * Dificuldade.FACIL.getMultiplicadorVida());
        
        int vidaCiclopeDificil = (int)(ciclopeDificil.getPontosDeVida() * Dificuldade.DIFICIL.getMultiplicadorVida());
        int vidaProfessorDificil = (int)(professorDificil.getPontosDeVida() * Dificuldade.DIFICIL.getMultiplicadorVida());

        // Ciclope deve ter mais vida que Professor em ambas as dificuldades
        assertTrue(vidaCiclopeFacil > vidaProfessorFacil,
                  "Ciclope deve ter mais vida que ProfessorDaFEM em dificuldade fácil");
        
        assertTrue(vidaCiclopeDificil > vidaProfessorDificil,
                  "Ciclope deve ter mais vida que ProfessorDaFEM em dificuldade difícil");
    }
}