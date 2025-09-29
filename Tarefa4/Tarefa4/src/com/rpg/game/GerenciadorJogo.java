package com.rpg.game;

import com.rpg.util.InputManager;
import com.rpg.cenario.Dificuldade;
import com.rpg.personagens.Heroi;
import com.rpg.cenario.Fase;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.cenario.ConstrutorDeCenarioFixo;
import java.util.List;

public class GerenciadorJogo {

    public static void iniciarJogo(Dificuldade dificuldade) {
        Heroi heroi = new Heroi("Herói", 100, 20);
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        
        List<Fase> fases = gerador.gerar(3, dificuldade);
        
        System.out.println("Jogo iniciado com dificuldade: " + dificuldade.getDescricao());
        
        boolean jogoAtivo = true;
        int faseAtual = 1;
        
        for (Fase fase : fases) {
            if (!jogoAtivo) break;
            
            System.out.println("\nFASE " + faseAtual);
            fase.iniciar(heroi);
            
            // Simulação de combate
            simularCombate(heroi, faseAtual);
            
            if (!heroi.estaVivo()) {
                System.out.println("Game Over");
                break;
            }
            
            exibirMenuPosCombate(heroi);
            
            if (!InputManager.lerSimNao("Deseja continuar para a próxima fase?")) {
                jogoAtivo = false;
            } else {
                faseAtual++;
            }
        }
        
        if (faseAtual > 3 && heroi.estaVivo()) {
            System.out.println("\nParabéns, Você venceu");
        }
        
        System.out.println("Fim do jogo");
        InputManager.esperarEnter("ENTER para voltar ao menu principal...");
    }

    private static void simularCombate(Heroi heroi, int fase) {
        System.out.println("Combate na fase " + fase);
        System.out.println(heroi.getNome() + " enfrenta um monstro");
        
        // Simulação simples de combate
        int danoMonstro = 10 + (fase * 5);
        heroi.receberDano(danoMonstro);
        System.out.println("Herói recebeu " + danoMonstro + " de dano. Vida restante: " + heroi.getPontosDeVida());
        
        if (!heroi.estaVivo()) {
            System.out.println("Game Over");
            return;
        }
        
        System.out.println("Monstro derrotado! Fase " + fase + " concluída");
    }

    private static void exibirMenuPosCombate(Heroi heroi) {
        while (true) {
            System.out.println("\n\nMENU PÓS-COMBATE");
            System.out.println("[1] Interagir com o Loot");
            System.out.println("[2] Informações do Personagem");
            System.out.println("[3] Ir para próxima fase");

            int opcao = InputManager.lerInteiro("Digite sua opção de 1 a 3", 1, 3);

            switch (opcao) {
                case 1:
                    System.out.println("Você encontrou uma poção de cura! Ganhe 20 de vida");
                    heroi.receberCura(20);
                    System.out.println("Vida atual: " + heroi.getPontosDeVida());
                    break;
                case 2:
                    exibirInfoPersonagem(heroi);
                    break;
                case 3:
                    return; 
            }
        }
    }

    private static void exibirInfoPersonagem(Heroi heroi) {
        System.out.println("\n\nINFORMAÇÕES DO PERSONAGEM");
        System.out.println("Nome: " + heroi.getNome());
        System.out.println("Vida: " + heroi.getPontosDeVida());
        System.out.println("Força: " + heroi.getForca());
        System.out.println("Status: " + (heroi.estaVivo() ? "Vivo" : "Morto"));
        InputManager.esperarEnter("ENTER para voltar...");
    }
}