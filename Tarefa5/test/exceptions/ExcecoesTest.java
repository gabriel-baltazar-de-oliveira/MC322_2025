package com.rpg.test.exceptions;

import com.rpg.exceptions.NivelInsuficienteException;
import com.rpg.exceptions.RecursoInsuficienteException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para as exceções personalizadas do sistema
 * 
 * <p>Esta classe verifica que as exceções são usadaas 
 * corretamente e gram mensagens adequadas para
 * ajudar na depuração e no tratamento de erros.</p>
 */
public class ExcecoesTest {

    /**
     * Testa a criação da NivelInsuficienteException
     * 
     * <p>Verifica que a exceção é criada corretamente e que
     * a mensagem de erro é preservada e pode ser recuperada.</p>
     */
    @Test
    public void testNivelInsuficienteException_Criacao() {
        String mensagemEsperada = "Nível 5 requerido, mas jogador está no nível 3";
        
        NivelInsuficienteException exception = 
            new NivelInsuficienteException(mensagemEsperada);
        
        assertNotNull(exception, "Exceção deve ser criada com sucesso");
        assertEquals(mensagemEsperada, exception.getMessage(), 
                    "Mensagem da exceção deve ser preservada");
    }

    /**
     * Testa que NivelInsuficienteException é do tipo Exception
     * 
     * <p>Verifica a hierarquia correta da exceção, garantindo
     * que ela pode ser capturada por blocos catch genéricos
     * de Exception quando necessário.</p>
     */
    @Test
    public void testNivelInsuficienteException_Hierarquia() {
        NivelInsuficienteException exception = 
            new NivelInsuficienteException("Teste de hierarquia");
        
        assertTrue(exception instanceof Exception, 
                  "NivelInsuficienteException deve ser uma Exception");
    }

    /**
     * Testa o lançamento de NivelInsuficienteException
     * 
     * <p>Verifica que a exceção pode ser usada e capturada
     * adequadamente em um cenário simulado de uso.</p>
     */
    @Test
    public void testNivelInsuficienteException_Lancamento() {
        String mensagemEsperada = "Não é possível equipar item: nível insuficiente";
        
        // Simula um método que lança a exceção
        Exception exception = assertThrows(NivelInsuficienteException.class, () -> {
            simularVerificacaoNivel(2, 5); // Nível 2 tentando usar item nível 5
        });
        
        assertEquals(mensagemEsperada, exception.getMessage(),
                    "Mensagem da exceção usada deve ser a esperada");
    }

    /**
     * Testa a criação da RecursoInsuficienteException
     * 
     * <p>Verifica que a exceção de recurso insuficiente é criada
     * corretamente e mantém a mensagem de erro informativa.</p>
     */
    @Test
    public void testRecursoInsuficienteException_Criacao() {
        String mensagemEsperada = "Mana insuficiente: 10 disponível, 25 requerido";
        
        RecursoInsuficienteException exception = 
            new RecursoInsuficienteException(mensagemEsperada);
        
        assertNotNull(exception, "Exceção deve ser criada com sucesso");
        assertEquals(mensagemEsperada, exception.getMessage(),
                    "Mensagem da exceção deve ser preservada");
    }

    /**
     * Testa que RecursoInsuficienteException é do tipo Exception
     * 
     * <p>Verifica a correta hierarquia de herança da exceção
     * de recurso insuficiente.</p>
     */
    @Test
    public void testRecursoInsuficienteException_Hierarquia() {
        RecursoInsuficienteException exception = 
            new RecursoInsuficienteException("Teste de hierarquia");
        
        assertTrue(exception instanceof Exception,
                  "RecursoInsuficienteException deve ser uma Exception");
    }

    /**
     * Testa o lançamento de RecursoInsuficienteException
     * 
     * <p>Verifica que a exceção é usada corretamente em
     * um cenário simulado de falta de recursos.</p>
     */
    @Test
    public void testRecursoInsuficienteException_Lancamento() {
        String mensagemEsperada = "Recursos insuficientes para usar habilidade";
        
        Exception exception = assertThrows(RecursoInsuficienteException.class, () -> {
            simularUsoHabilidade(10, 25); // 10 de mana, precisa de 25
        });
        
        assertEquals(mensagemEsperada, exception.getMessage(),
                    "Mensagem da exceção usada deve ser a esperada");
    }

    /**
     * Testa que as exceções têm mensagens diferentes
     * 
     * <p>Verifica que as duas exceções testadas são distintas
     * e tratam de problemas diferentes no domínio do jogo.</p>
     */
    @Test
    public void testExcecoesSaoDistintas() {
        NivelInsuficienteException exNivel = 
            new NivelInsuficienteException("Erro de nível");
        RecursoInsuficienteException exRecurso = 
            new RecursoInsuficienteException("Erro de recurso");
        
        // Verifica que são tipos diferentes
        assertNotSame(exNivel.getClass(), exRecurso.getClass(),
                     "Exceções devem ser de tipos diferentes");
        
        // Verifica que ambas são Exceptions mas não a mesma
        assertTrue(exNivel instanceof Exception);
        assertTrue(exRecurso instanceof Exception);
    }

    /**
     * Testa mensagens informativas nas exceções
     * 
     * <p>Verifica que as exceções suportam mensagens detalhadas
     * que podem ajudar os desenvolvedores e jogadores a entender
     * o que deu errado.</p>
     */
    @Test
    public void testMensagensInformativas() {
        // Testa mensagem complexa para NivelInsuficienteException
        String mensagemComplexaNivel = "Jogador 'Herói' nível 3 não pode equipar 'Espada Lendária' (nível 10)";
        NivelInsuficienteException exNivel = 
            new NivelInsuficienteException(mensagemComplexaNivel);
        
        assertEquals(mensagemComplexaNivel, exNivel.getMessage(),
                    "Deve suportar mensagens complexas e informativas");
        
        // Testa mensagem complexa para RecursoInsuficienteException  
        String mensagemComplexaRecurso = "Habilidade 'Bola de Fogo' requer 50 de mana, mas jogador tem apenas 30";
        RecursoInsuficienteException exRecurso = 
            new RecursoInsuficienteException(mensagemComplexaRecurso);
        
        assertEquals(mensagemComplexaRecurso, exRecurso.getMessage(),
                    "Deve suportar mensagens complexas e informativas");
    }

    
    /**
     * Simula a verificação de nível que lança exceção
     * 
     * @param nivelAtual Nível atual do jogador
     * @param nivelRequerido Nível mínimo requerido
     * @throws NivelInsuficienteException Quando o nível é insuficiente
     */
    private void simularVerificacaoNivel(int nivelAtual, int nivelRequerido) 
            throws NivelInsuficienteException {
        if (nivelAtual < nivelRequerido) {
            throw new NivelInsuficienteException(
                "Não é possível equipar item: nível insuficiente");
        }
        // Continua normalmente se nível for suficiente
    }

    /**
     * Simula o uso de habilidade que verifica recursos
     * 
     * @param recursoDisponível Quantidade disponível do recurso
     * @param recursoRequerido Quantidade requerida do recurso
     * @throws RecursoInsuficienteException Quando recursos são insuficientes
     */
    private void simularUsoHabilidade(int recursoDisponivel, int recursoRequerido) 
            throws RecursoInsuficienteException {
        if (recursoDisponivel < recursoRequerido) {
            throw new RecursoInsuficienteException(
                "Recursos insuficientes para usar habilidade");
        }
        // Usa habilidade se recursos forem suficientes
    }
}