public class Main {
    public static void main(String[] args) {
        System.out.println("O HERÓI ENTRA NA MASMORRA PARA ENFRENTAR TRÊS DESAFIOS!");
        System.out.println("Ele precisará usar força, fé e estratégia para sobreviver a monstros perigosos.\n");

        // Criação do herói
        Arqueira heroi = new Arqueira("Isabela Marcondes", 50.0, 20.0, 5.0, 0.0, "Diamante", 50.0);

        System.out.println("Status inicial do herói:");
        System.out.println(heroi.exibirStatus());
        System.out.println();

        // Criação dos monstros
        monstro[] monstros = new monstro[3];
        monstros[0] = new Ciclope("Ciclope Gigante", 80.0, 15.0, 30.0, 40.0);
        monstros[1] = new ProfessorDaFEM("Professor da FEM", 60.0, 10.0, 50.0, 35.0);
        monstros[2] = new ElefantePsíquico("Elefante Psíquico", 90.0, 12.0, 45.0, 50.0);

        // Loop dos turnos
        for (int i = 0; i < monstros.length; i++) {
            monstro atual = monstros[i];
            System.out.println("Turno " + (i + 1) + ": Chega o monstro " + atual.nome + "!");

            // Batalha até um dos dois morrer
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

        System.out.println("PARABÉNS! O herói sobreviveu aos três desafios da masmorra!");
    }
}
