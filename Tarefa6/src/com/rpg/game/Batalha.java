package com.rpg.game;

import com.rpg.cenario.ConstrutorDeCenarioFixo;
import com.rpg.cenario.Dificuldade;
import com.rpg.cenario.Fase;
import com.rpg.cenario.GeradorDeFases;
import com.rpg.items.Item;
import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import com.rpg.util.InputManager;
import java.util.ArrayList;
import java.util.List;

public class Batalha {
    private Heroi heroi;
    private List<Fase> fases;
    private int faseAtual;
    private Dificuldade dificuldade;
    private boolean jogoAtivo;
    private List<Item> lootDisponivel; // Loot guardado após o combate

    public Batalha() {
        this.fases = new ArrayList<>();
        this.lootDisponivel = new ArrayList<>();
    }

    public Batalha(Dificuldade dificuldade) {
        this(); // Chama o construtor padrão para inicializar as listas
        this.heroi = new Heroi("Herói", 100, 20);
        this.dificuldade = dificuldade;
        this.faseAtual = 0;
        this.jogoAtivo = true;

        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        this.fases = gerador.gerar(3, dificuldade);
    }

    public Batalha(Heroi heroi, List<Fase> fases, int faseAtual, Dificuldade dificuldade) {
        this.heroi = heroi;
        this.fases = fases;
        this.faseAtual = faseAtual;
        this.dificuldade = dificuldade;
        this.jogoAtivo = true;
        this.lootDisponivel = new ArrayList<>(); // Garante que a lista não seja nula
    }

    public void executarProxFase() {
        if (!jogoAtivo || faseAtual >= fases.size()) {
            System.out.println("Não há mais fases para executar.");
            return;
        }

        Fase fase = fases.get(faseAtual);
        System.out.println("\n=== FASE " + (faseAtual + 1) + " ===");
        fase.iniciar(heroi);
        simularCombate(faseAtual + 1);
        // Monta uma string com os nomes dos monstros na fase
        if (fase.getMonstros() != null && !fase.getMonstros().isEmpty()) {
            StringBuilder nomesDosMonstros = new StringBuilder();
            for (int i = 0; i < fase.getMonstros().size(); i++) {
                nomesDosMonstros.append(fase.getMonstros().get(i).getNome());
                // Adiciona vírgula e espaço se não for o último monstro da lista
                if (i < fase.getMonstros().size() - 1) {
                nomesDosMonstros.append(", ");
            }
        }
    }
    System.out.println("----------------------------------------"); 
        if (!heroi.estaVivo()) {
            System.out.println("Game Over - Seu herói foi derrotado!");
            jogoAtivo = false;
            return;
        }

        exibirMenuPosCombate();

        faseAtual++;

        if (faseAtual >= fases.size() && heroi.estaVivo()) {
            System.out.println("\nParabéns! Você completou todas as fases e venceu o jogo!");
            jogoAtivo = false;
        }
    }

    private void simularCombate(int numeroFase) {
    // 1. Pega o monstro real da fase atual
    Fase faseAtualObj = this.fases.get(this.faseAtual);
    if (faseAtualObj.getMonstros() == null || faseAtualObj.getMonstros().isEmpty()) {
        System.out.println("AVISO: Fase sem monstros. Avançando automaticamente.");
        return;
    }
    Monstro monstroDaFase = faseAtualObj.getMonstros().get(0);

    System.out.println("Combate na fase " + numeroFase);
    System.out.println(heroi.getNome() + " enfrenta um " + monstroDaFase.getNome() + "!");

    // 2. O dano vem DIRETAMENTE dos status do monstro
    // Usamos o getDanoFisico(), que já definimos que é a força por padrão.
    int danoMonstro = monstroDaFase.getDanoFisico(); 

    heroi.receberDano(danoMonstro);
    System.out.println("O " + monstroDaFase.getNome() + " ataca! Herói recebeu " + danoMonstro + " de dano. Vida restante: " + heroi.getPontosDeVida());

    if (heroi.estaVivo()) {
        System.out.println(monstroDaFase.getNome() + " derrotado! Fase " + numeroFase + " concluída.");
        
        // USANDO O GERENCIADOR DE LOOT DE VERDADE
        List<Monstro> monstrosDerrotados = new ArrayList<>();
        monstrosDerrotados.add(monstroDaFase);

        this.lootDisponivel = com.rpg.combate.GerenciadorLoot.processarLoot(monstrosDerrotados);

        if (!this.lootDisponivel.isEmpty()) {
            System.out.println("O monstro deixou cair alguns itens!");
        } else {
            System.out.println("O monstro não deixou nenhum item.");
        }
    }
}

    private void exibirMenuPosCombate() {
        while (true) {
            System.out.println("\n MENU PÓS-COMBATE ");
            System.out.println("[1] Interagir com o Loot");
            System.out.println("[2] Informações do Personagem");
            System.out.println("[3] Salvar Jogo");
            System.out.println("[4] Ir para próxima fase");

            int opcao = InputManager.lerInteiro("Digite sua opção de 1 a 4", 1, 4);

            switch (opcao) {
                case 1:
                    interagirComLoot();
                    break;
                case 2:
                    exibirInfoPersonagem();
                    break;
                case 3:
                    salvarJogo();
                    break;
                case 4:
                    return; // Retorna para executarProxFase, que vai avançar a fase.
            }
        }
    }
    
    private void interagirComLoot() {
        if (lootDisponivel == null || lootDisponivel.isEmpty()) {
            System.out.println("Nenhum item foi encontrado para interagir.");
            InputManager.esperarEnter("Pressione ENTER para voltar...");
            return;
        }

        while (true) {
            System.out.println("\n ITENS ENCONTRADO ");
            for (int i = 0; i < lootDisponivel.size(); i++) {
                System.out.println("[" + (i + 1) + "] " + lootDisponivel.get(i).getNome());
            }
            System.out.println("[0] Voltar");

            int opcao = InputManager.lerInteiro("Escolha um item para usar/equipar (ou 0 para voltar)", 0, lootDisponivel.size());

            if (opcao == 0) {
                return;
            }

            Item itemEscolhido = lootDisponivel.get(opcao - 1);

            heroi.equiparItem(itemEscolhido); 
            System.out.println("Você usou/equipou: " + itemEscolhido.getNome());
            
            lootDisponivel.remove(itemEscolhido);

            InputManager.esperarEnter("Pressione ENTER para continuar...");

            if (lootDisponivel.isEmpty()) {
                System.out.println("Você coletou todos os itens.");
                InputManager.esperarEnter("Pressione ENTER para voltar...");
                return;
            }
        }
    }

    private void exibirInfoPersonagem() {
        System.out.println("\n INFORMAÇÕES DO PERSONAGEM ");
        heroi.exibirInfo(); // Supondo que o herói tenha um método para exibir suas próprias informações
        InputManager.esperarEnter("Pressione ENTER para voltar...");
    }

    public void salvarJogo() {
        try {
            String nomeSave = "save_" + System.currentTimeMillis();
            GerenciadorDePersistencia.salvarBatalha(this, nomeSave);
            
            System.out.println("Progresso salvo com sucesso!");
            InputManager.esperarEnter("Pressione ENTER para continuar...");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o jogo: " + e.getMessage());
            InputManager.esperarEnter("Pressione ENTER para continuar...");
        }
    }

    // GETTERS e SETTERS
    public Heroi getHeroi() { return heroi; }
    public List<Fase> getFases() { return fases; }
    public int getFaseAtual() { return faseAtual; }
    public Dificuldade getDificuldade() { return dificuldade; }
    public boolean isJogoAtivo() { return jogoAtivo; }
    public void setJogoAtivo(boolean jogoAtivo) { this.jogoAtivo = jogoAtivo; }
    public List<Item> getLootDisponivel() { return lootDisponivel; }
    public void setLootDisponivel(List<Item> lootDisponivel) { this.lootDisponivel = lootDisponivel; }
}