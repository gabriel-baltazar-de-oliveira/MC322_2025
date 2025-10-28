package com.rpg.test.util;

import com.rpg.util.InputManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets; // <-- 1. ADICIONADO ESTE IMPORT

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe InputManager
 * * <p>Esta classe testa os métodos de entrada de dados do usuário,
 * verificando tanto casos válidos quanto inválidos para garantir
 * a funcinalidade do sistema de input.</p>
 */
public class InputManagerTest {
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private ByteArrayInputStream testIn;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Configura o ambiente de teste antes de cada método
     * * <p>Redireciona System.out para capturar as saídas do programa
     * durante a execução dos testes.</p>
     */
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Restaura os streams originais após cada teste
     * * <p>Esta é uma boa prática para evitar que testes interfiram
     * uns com os outros ao modificar System.in e System.out.</p>
     */
    @AfterEach
    void restoreStreams() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    /**
     * Simula entrada do usuário para testes
     * * @param data String contendo a entrada a ser simulada
     */
    private void provideInput(String data) {
        // --- 2. LINHA CORRIGIDA ---
        // Força o getBytes() a usar UTF-8, igual ao Scanner
        testIn = new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8));
        System.setIn(testIn);
        
        InputManager.resetScanner();
    }

    /**
     * Testa o método lerString com entrada válida
     * * <p>Verifica se o método retorna corretamente uma string
     * não vazia fornecida pelo usuário.</p>
     */
    @Test
    public void testLerString_ValidInput() {
        provideInput("Teste\n");
        String resultado = InputManager.lerString("Digite algo: ");
        assertEquals("Teste", resultado);
    }

    /**
     * Testa o método lerString com entrada vazia seguida de válida
     * * <p>Verifica se o método trata corretamente entradas vazias,
     * solicitando nova entrada até receber um valor válido.</p>
     */
    @Test
    public void testLerString_EmptyThenValidInput() {
        provideInput("\nTexto válido\n"); // Esta string com "á" vai funcionar
        String resultado = InputManager.lerString("Digite algo: ");
        assertEquals("Texto válido", resultado); // A comparação vai bater
        
        String output = outContent.toString();
        // A mensagem de erro também precisa ser comparada com a
        // codificação correta, o que o 'toString()' padrão deve fazer.
        assertTrue(output.contains("Entrada vazia. Digite um texto válido."));
    }

    /**
     * Testa o método lerSimNao com entrada 's' (sim)
     * * <p>Verifica se o método retorna true quando o usuário
     * digita 's'.</p>
     */
    @Test
    public void testLerSimNao_InputS() {
        provideInput("s\n");
        boolean resultado = InputManager.lerSimNao("Deseja continuar?");
        assertTrue(resultado);
    }

    /**
     * Testa o método lerSimNao com entrada 'n' (não)
     * * <p>Verifica se o método retorna false quando o usuário
     * digita 'n'.</p>
     */
    @Test
    public void testLerSimNao_InputN() {
        provideInput("n\n");
        boolean resultado = InputManager.lerSimNao("Deseja continuar?");
        assertFalse(resultado);
    }

    /**
     * Testa o método lerSimNao com entrada inválida seguida de válida
     * * <p>Verifica se o método trata entradas inválidas corretamente,
     * solicitando nova entrada até receber 's' ou 'n'.</p>
     */
    @Test
    public void testLerSimNao_InvalidThenValidInput() {
        provideInput("x\ns\n");
        boolean resultado = InputManager.lerSimNao("Deseja continuar?");
        assertTrue(resultado);
        
        String output = outContent.toString();
        assertTrue(output.contains("Entrada inválida. Digite 's' para sim ou 'n' para não."));
    }

    /**
     * Testa o método esperarEnter com entrada simples
     * * <p>Verifica se o método funciona corretamente quando
     * o usuário pressiona ENTER.</p>
     */
    @Test
    public void testEsperarEnter() {
        provideInput("\n");
        InputManager.esperarEnter("Pressione ENTER...");
        
        // Verifica se a mensagem foi exibida
        String output = outContent.toString();
        assertTrue(output.contains("Pressione ENTER..."));
    }
}
