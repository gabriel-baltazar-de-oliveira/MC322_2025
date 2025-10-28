package com.rpg.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Gerenciador de entrada de dados do usuário via console.
 * * <p>Esta classe fornece métodos utilitários para ler e validar
 * entradas do usuário, garantindo que o programa não quebre
 * com entradas inválidas e forneça feedback ao jogador.</p>
 *
 */
public class InputManager {
    
    // O scanner não é mais inicializado aqui.
    // Isso permite que ele seja resetado para os testes.
    private static Scanner scanner;

    /**
     * Obtém a instância do scanner, criando uma nova se for nula.
     * Isso garante que o scanner esteja sempre pronto e permite
     * que ele pegue um novo System.in (para testes) se for resetado.
     * * @return A instância do Scanner.
     */
    private static Scanner getScanner() {
        if (scanner == null) {
            // Adiciona "UTF-8" para corrigir problemas de acentuação no console
            scanner = new Scanner(System.in, "UTF-8");
        }
        return scanner;
    }

    /**
     * Reseta o scanner (usado APENAS para testes).
     * Define o scanner como nulo para forçar a criação de um novo
     * na próxima chamada de getScanner(), que usará o System.in simulado.
     */
    public static void resetScanner() {
        scanner = null;
    }

    /**
     * Lê um número inteiro dentro de um intervalo específico.
     * * <p>Este método exibe uma mensagem e fica em loop até que
     * o usuário forneça um número inteiro válido dentro do
     * intervalo especificado. Fornece feedback sobre erros.</p>
     *
     * @param mensagem Mensagem a ser exibida para o usuário
     * @param min Valor mínimo permitido (inclusive)
     * @param max Valor máximo permitido (inclusive)
     * @return Número inteiro válido dentro do intervalo
     * @throws RuntimeException Se a entrada não estiver disponível
     */
    public static int lerInteiro(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem + " (" + min + " - " + max + "): ");
            String input = null;
            try {
                // USA getScanner()
                input = getScanner().nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite um número entre " + min + " e " + max + ".");
                    continue;
                }
                int valor = Integer.parseInt(input);
                if (valor < min || valor > max) {
                    System.out.println("Fora do intervalo. Digite um número entre " + min + " e " + max + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }
    }

    /**
     * Lê uma string não vazia do usuário.
     * * <p>Garante que o usuário forneça uma string válida não vazia,
     * solicitando nova entrada caso necessário.</p>
     *
     * @param mensagem Mensagem a ser exibida para o usuário
     * @return String não vazia fornecida pelo usuário
     * @throws RuntimeException Se a entrada não estiver disponível
     */
    public static String lerString(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                // USA getScanner()
                String input = getScanner().nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Entrada vazia. Digite um texto válido.");
                    continue;
                }
                return input;
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }
    }

    /**
     * Lê uma resposta sim/não do usuário.
     * * <p>Aceita apenas 's' para sim ou 'n' para não, em qualquer
     * caso (maiúsculo ou minúsculo).</p>
     *
     * @param mensagem Mensagem a ser exibida para o usuário
     * @return true para 's' (sim), false para 'n' (não)
     * @throws RuntimeException Se a entrada não estiver disponível
     */
    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (s/n): ");
            try {
                // USA getScanner()
                String input = getScanner().nextLine().trim().toLowerCase();
                if (input.equals("s")) {
                    return true;
                } else if (input.equals("n")) {
                    return false;
                } else {
                    System.out.println("Entrada inválida. Digite 's' para sim ou 'n' para não.");
                }
            } catch (NoSuchElementException e) {
                throw new RuntimeException("Entrada não disponível.", e);
            }
        }
    }

    /**
     * Espera o usuário pressionar ENTER para continuar.
     * * <p>Útil para pausas no jogo onde o jogador precisa ler
     * informações antes de continuar.</p>
     *
     * @param mensagem Mensagem a ser exibida para o usuário
     * @throws RuntimeException Se a entrada não estiver disponível
     */
    public static void esperarEnter(String mensagem) {
        System.out.print(mensagem);
        try {
            // USA getScanner()
            getScanner().nextLine();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Entrada não disponível.", e);
        }
    }

    /*
     * O método fecharScanner() foi removido.
     * Nunca devemos fechar um Scanner que está lendo de System.in,
     * pois isso fecha o System.in para todo o programa e
     * impede que testes futuros funcionem.
     */
}
