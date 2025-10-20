package com.rpg.game;

/**
 * Classe principal do RPG - ponto de entrada da aplicação.
 * 
 * <p>Atualizada para a Tarefa 6 com verificação de saves
 * e inicialização do sistema de menus.</p>
 * 
 * @author RPG Development Team
 * @version 2.0
 */
public class Main {
    
    /**
     * Método principal - ponto de entrada do programa.
     * 
     * <p>Verifica a existência de jogos salvos e inicia
     * o menu principal do jogo.</p>
     *
     * @param args Argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        System.out.println("RPG - Tarefa 6");
        System.out.println("==================");
        
        // Verifica e exibe informações sobre saves
        verificarSavesExistentes();
        
        // Inicia o menu principal
        MenuPrincipal.mostrarMenu();
    }
    
    /**
     * Verifica e exibe informações sobre jogos salvos.
     */
    private static void verificarSavesExistentes() {
        if (GerenciadorDePersistencia.existemJogosSalvos()) {
            String[] saves = GerenciadorDePersistencia.listarJogosSalvos();
            System.out.println(saves.length + " jogo(s) salvo(s) encontrado(s)");
            System.out.println("Use 'Carregar Jogo' no menu para continuar sua aventura!");
        } else {
            System.out.println("Nenhum jogo salvo encontrado");
            System.out.println("Inicie uma nova aventura selecionando 'Novo Jogo'!");
        }
        System.out.println();
    }
}