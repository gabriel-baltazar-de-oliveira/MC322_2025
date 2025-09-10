import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("O HERÓI ENTRA NA MASMORRA PARA ENFRENTAR UM DESAFIO DE SOBREVIVÊNCIA!");
        System.out.println(
                "Ele precisará usar força, fé e estratégia para sobreviver a monstros cada vez mais fortes.\n");

        // Criação do herói
        Paladino heroi = new Paladino("Sir Gabriel", 150.0, 20.0, 5.0, 0.0, "Luz Sagrada", 50.0);

        System.out.println("Status inicial do herói:");
        System.out.println(heroi.exibirStatus());
        System.out.println();

        // Lista base de monstros (nível inicial, sem buffs)
        List<monstro> monstrosBase = new ArrayList<>();
        monstrosBase.add(new Ciclope("Ciclope Gigante", 80.0, 15.0, 30.0, 40.0));
        monstrosBase.add(new ProfessorDaFEM("Professor da FEM", 60.0, 10.0, 50.0, 35.0));
        monstrosBase.add(new ElefantePsíquico("Elefante Psíquico", 90.0, 12.0, 45.0, 50.0));

        // Criando a fase com nível 2 (dificuldade aumentada)
        Fase fase1 = new Fase(2, "Catacumbas da Universidade Sombria", monstrosBase);

        // Exibindo informações da fase
        fase1.exibirFase();

        // Loop para batalhar contra todos os monstros da fase
        for (monstro atual : fase1.getMonstros()) {
            System.out.println("Chega o monstro " + atual.nome + "!");

            // Batalha até um dos dois cair
            while (heroi.pontosDeVida > 0 && atual.pontosDeVida > 0) {
                // Herói ataca
                System.out.println(heroi.atacar(atual));
                atual.pontosDeVida -= heroi.forca;
                if (atual.pontosDeVida <= 0) {
                    System.out.println("O monstro " + atual.nome + " foi derrotado!\n");
                    break;
                }

                // Monstro ataca
                System.out.println(atual.atacar(heroi));
                heroi.pontosDeVida -= atual.forca;
                if (heroi.pontosDeVida <= 0) {
                    System.out.println("\nO herói foi derrotado pelo monstro " + atual.nome + "!");
                    System.out.println("GAME OVER");
                    return;
                }

                // Exibe status parcial
                System.out.println("\nStatus atual:");
                System.out.println("Herói:");
                System.out.println(heroi.exibirStatus());
                System.out.println("Monstro:");
                System.out.println(atual.exibirStatus());
                System.out.println("-----------------------------\n");
            }
        }

        System.out.println("PARABÉNS! O herói sobreviveu a todos os monstros desta fase!");
    }
}
