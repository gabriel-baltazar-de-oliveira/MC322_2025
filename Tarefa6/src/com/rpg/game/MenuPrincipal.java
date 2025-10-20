package com.rpg.game;

import com.rpg.cenario.Dificuldade;
import com.rpg.util.InputManager;

/**
 * Menu principal do jogo com opções atualizadas para salvar/carregar.
 * 
 * <p>Atualizado para incluir a opção de carregar jogo salvo e
 * integrar com o novo sistema de batalha e persistência.</p>
 * 
 */
public class MenuPrincipal {

    public static void mostrarMenu() {
        while (true) {
            System.out.println("\n\n TAREFA 6 RPG ");
            System.out.println("[1] Novo Jogo");
            
            // Mostra opção de carregar apenas se existirem saves
            if (GerenciadorDePersistencia.existemJogosSalvos()) {
                System.out.println("[2] Carregar Jogo");
                System.out.println("[3] Informações dos Heróis");
                System.out.println("[4] Informações dos Monstros");
                System.out.println("[5] Sair do Jogo");
            } else {
                System.out.println("[2] Informações dos Heróis");
                System.out.println("[3] Informações dos Monstros");
                System.out.println("[4] Sair do Jogo");
            }

            int maxOpcao = GerenciadorDePersistencia.existemJogosSalvos() ? 5 : 4;
            int opcao = InputManager.lerInteiro("Escolha o que fazer", 1, maxOpcao);

            // Ajusta a opção se não houver saves
            if (!GerenciadorDePersistencia.existemJogosSalvos() && opcao >= 2) {
                opcao++; // Desloca as opções para cima
            }

            switch (opcao) {
                case 1:
                    iniciarNovoJogo();
                    break;
                case 2:
                    if (GerenciadorDePersistencia.existemJogosSalvos()) {
                        carregarJogoSalvo();
                    } else {
                        InfoHerois();
                    }
                    break;
                case 3:
                    if (GerenciadorDePersistencia.existemJogosSalvos()) {
                        InfoHerois();
                    } else {
                        InfoMonstros();
                    }
                    break;
                case 4:
                    if (GerenciadorDePersistencia.existemJogosSalvos()) {
                        InfoMonstros();
                    } else {
                        sairDoJogo();
                    }
                    break;
                case 5:
                    sairDoJogo();
                    break;
            }
        }
    }

    /**
     * Inicia um novo jogo com seleção de dificuldade.
     */
    private static void iniciarNovoJogo() {
        System.out.println("\n\n=== SELECIONE A DIFICULDADE ===");
        System.out.println("[1] Fácil");
        System.out.println("[2] Média");
        System.out.println("[3] Difícil");

        int opcaoDificuldade = InputManager.lerInteiro("Escolha sua dificuldade de 1 a 3", 1, 3);
        
        Dificuldade dificuldade;
        switch (opcaoDificuldade) {
            case 1: 
                dificuldade = Dificuldade.FACIL; 
                break;
            case 2: 
                dificuldade = Dificuldade.MEDIA; 
                break;
            case 3: 
                dificuldade = Dificuldade.DIFICIL; 
                break;
            default: 
                dificuldade = Dificuldade.MEDIA;
        }

        System.out.println("Dificuldade selecionada: " + dificuldade.getDescricao());
        InputManager.esperarEnter("Pressione ENTER para começar...");
        
        // Inicia uma nova batalha
        GerenciadorJogo.iniciarJogo(dificuldade);
    }

    /**
     * Carrega um jogo salvo existente.
     */
    private static void carregarJogoSalvo() {
        String[] saves = GerenciadorDePersistencia.listarJogosSalvos();
        
        if (saves.length == 0) {
            System.out.println("Nenhum jogo salvo encontrado.");
            InputManager.esperarEnter("Pressione ENTER para voltar...");
            return;
        }

        System.out.println("\n\n=== JOGOS SALVOS ===");
        for (int i = 0; i < saves.length; i++) {
            System.out.println("[" + (i + 1) + "] " + saves[i]);
        }
        
        int opcao = InputManager.lerInteiro("Escolha o jogo para carregar", 1, saves.length);
        String saveSelecionado = saves[opcao - 1];
        
        try {
            Batalha batalhaCarregada = GerenciadorDePersistencia.carregarBatalha(saveSelecionado);
            executarBatalhaCarregada(batalhaCarregada);
        } catch (Exception e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
            InputManager.esperarEnter("Pressione ENTER para voltar...");
        }
    }

    /**
     * Executa uma batalha carregada de um save.
     * 
     * @param batalha Batalha carregada do arquivo de save
     */
    private static void executarBatalhaCarregada(Batalha batalha) {
        System.out.println("Jogo carregado com sucesso!");
        System.out.println("Progresso: Fase " + (batalha.getFaseAtual() + 1) + " de " + batalha.getFases().size());
        System.out.println("Herói: " + batalha.getHeroi().getNome() + " (Vida: " + batalha.getHeroi().getPontosDeVida() + ")");
        
        InputManager.esperarEnter("Pressione ENTER para continuar...");
        
        // Executa as fases restantes
        while (batalha.isJogoAtivo() && batalha.getFaseAtual() < batalha.getFases().size()) {
            batalha.executarProxFase();
        }
        
        System.out.println("\n=== FIM DO JOGO ===");
        InputManager.esperarEnter("Pressione ENTER para voltar ao menu principal...");
    }

    /**
     * Exibe informações sobre os heróis disponíveis.
     */
    private static void InfoHerois() {
        System.out.println("\n\n=== INFORMAÇÕES DOS HERÓIS ===");
        System.out.println("• Herói: Classe básica com ataque e habilidade especial");
        System.out.println("• Arqueira: Ataques à distância, usa agilidade para dano extra");
        System.out.println("• Bruxa: Magias poderosas, usa inteligência para feitiços");
        System.out.println("• Paladino: Combina força e fé, habilidades sagradas");
        System.out.println("\nSistema de Combate Atualizado:");
        System.out.println("- Ações compartilhadas entre personagens");
        System.out.println("- Dano calculado por atributos padronizados");
        System.out.println("- Sem necessidade de casting entre classes");
        InputManager.esperarEnter("Pressione ENTER para voltar...");
    }

    /**
     * Exibe informações sobre os monstros do jogo.
     */
    private static void InfoMonstros() {
        System.out.println("\n\n=== INFORMAÇÕES DOS MONSTROS ===");
        System.out.println("- Ciclope: Monstro com ataque poderoso (50% chance de drop)");
        System.out.println("- ProfessorDaFEM: Mestre das artes avaliativas (40% chance de drop)");
        System.out.println("- ElefantePsíquico: Monstro com poderes mentais (35% chance de drop)");
        System.out.println("\nSistema de Loot Atualizado:");
        System.out.println("- Itens instanciados apenas quando dropados");
        System.out.println("- Tabelas de loot específicas por monstro");
        System.out.println("- Agregação correta com Gerenciador de Itens");
        InputManager.esperarEnter("Pressione ENTER para voltar...");
    }

    /**
     * Finaliza o jogo com mensagem de saída.
     */
    private static void sairDoJogo() {
        System.out.println("Obrigado por jogar! Até a próxima aventura!");
        InputManager.fecharScanner();
        System.exit(0);
    }
}