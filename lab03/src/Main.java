import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria o gerador de fases e o herói
        GeradorDeFases gerador = new ConstrutorDeCenarioFixo();
        Heroi heroi = new Heroi("Arthur", 280, 40);

        // Gera 3 fases
        List<Fase> fases = gerador.gerar(3);

        // Loop pelas fases
        for (Fase fase : fases) {
            if (!(fase instanceof FaseDeCombate)) continue; // garante que seja de combate
            FaseDeCombate faseCombate = (FaseDeCombate) fase;

            // Exibe e aplica efeitos do cenário
            System.out.println("\nNova fase! Cenário: " + faseCombate.getDescricion());
            faseCombate.aplicarEfeitos(heroi);

            // Inicia a fase
            faseCombate.iniciar(heroi);

            // Loop pelos monstros da fase
            for (Monstro monstro : faseCombate.getMonstros()) {
                System.out.println(monstro.getNome() + " aparece!");

                while (heroi.estaVivo() && monstro.estaVivo()) {
                    // Ação do herói
                    AcaoDeCombate acaoHeroi = heroi.escolherAcao(monstro);
                    acaoHeroi.executar(heroi, monstro);

                    if (!monstro.estaVivo()) {
                        System.out.println(monstro.getNome() + " derrotado!");
                        if (monstro instanceof Lootavel) {
                            Lootavel lootavel = (Lootavel) monstro;
                            lootavel.droparLoot();
                        }
                        break;
                    }

                    // Ação do monstro
                    AcaoDeCombate acaoMonstro = monstro.escolherAcao(heroi);
                    acaoMonstro.executar(monstro, heroi);

                    if (!heroi.estaVivo()) {
                        System.out.println(heroi.getNome() + " foi derrotado! Game Over.");
                        return;
                    }
                }
            }

            // Marca fase como concluída
            faseCombate.setConcluida(true);
        }

        System.out.println("\nParabéns! " + heroi.getNome() + " completou todas as fases!");
    }
}
