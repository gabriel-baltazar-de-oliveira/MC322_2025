package com.rpg.game;

import com.rpg.cenario.Dificuldade;
import com.rpg.util.InputManager;

public class MenuPrincipal {

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n\nTAREFA 4 – RPG");
            System.out.println("[1] Novo Jogo");
            System.out.println("[2] Informações dos Heróis");
            System.out.println("[3] Informações dos Monstros");
            System.out.println("[4] Sair do Jogo");

            int opcao = InputManager.lerInteiro("Escolha o que fazer entre 1 e 4", 1, 4);

            switch (opcao) {
                case 1:
                    iniciarNovoJogo();
                    break;
                case 2:
                    InfoHerois();
                    break;
                case 3:
                    InfoMonstros();
                    break;
                case 4:
                    System.out.println("Saída");
                   // InputManager.fecharScanner();
                    return;
            }
        }
    }

    private static void iniciarNovoJogo() {
        System.out.println("\n\nSELECIONE A DIFICULDADE");
        System.out.println("[1] Fácil");
        System.out.println("[2] Média");
        System.out.println("[3] Difícil");

        int opcaoDificuldade = InputManager.lerInteiro("Escolha sua dificuldade de 1 a 3", 1, 3);
        
        Dificuldade dificuldade;
        switch (opcaoDificuldade) {
            case 1: dificuldade = Dificuldade.FACIL; break;
            case 2: dificuldade = Dificuldade.MEDIA; break;
            case 3: dificuldade = Dificuldade.DIFICIL; break;
            default: dificuldade = Dificuldade.MEDIA;
        }

        System.out.println("Dificuldade: " + dificuldade.getDescricao());
        InputManager.esperarEnter("ENTER para começar...");
        
        GerenciadorJogo.iniciarJogo(dificuldade);
    }

    private static void InfoHerois() {
        System.out.println("\n\nINFORMAÇÕES DOS HERÓIS");
        System.out.println("• Herói: Classe básica com ataque e habilidade especial");
        System.out.println("• Arqueira: Ataques à distância, usa agilidade para dano extra");
        System.out.println("• Bruxa: Magias poderosas, usa inteligência para feitiços");
        System.out.println("• Paladino: Combina força e fé, habilidades sagradas");
        InputManager.esperarEnter("ENTER para voltar...");
    }

    private static void InfoMonstros() {
        System.out.println("\n\nINFORMAÇÕES DOS MONSTROS");
        System.out.println("- Ciclope: Monstro com ataque poderoso");
        System.out.println("- ProfessorDaFEM: Mestre das artes avaliativas");
        System.out.println("- ElefantePsíquico: Monstro com poderes mentais");
        InputManager.esperarEnter("Pressione ENTER para voltar...");
    }
}