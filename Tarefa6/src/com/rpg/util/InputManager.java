package com.rpg.util;

import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Gerenciador de entrada de dados do usuário via console.
 * 
 * <p>Esta classe fornece métodos utilitários para ler e validar
 * entradas do usuário, garantindo que o programa não quebre
 * com entradas inválidas e forneça feedback adequado ao jogador.</p>
 * 
 */
public class InputManager {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Lê um número inteiro dentro de um intervalo específico.
     */
    public static int lerInteiro(String mensagem, int min, int max) {
        while (true) {
            System.out.print(mensagem + " (" + min + " - " + max + "): ");
            String input = null;
            try {
                input = scanner.nextLine().trim();
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
     */
    public static String lerString(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                String input = scanner.nextLine().trim();
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
     */
    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (s/n): ");
            try {
                String input = scanner.nextLine().trim().toLowerCase();
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
     */
    public static void esperarEnter(String mensagem) {
        System.out.print(mensagem);
        try {
            scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Entrada não disponível.", e);
        }
    }

    /**
     * Fecha o scanner de entrada.
     */
    public static void fecharScanner() {
        scanner.close();
    }
}