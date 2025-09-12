import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Fase> fases = ConstrutorDeCenario.gerarFases(3);
        
        for (int i = 0; i < fases.size(); i++) {
            Fase fase = fases.get(i);
            int nivelFase = fase.getNivel();
            
            int vidaBase = 30 + (nivelFase * 10);
            int forcaBase = 8 + (nivelFase * 2);
            int xpBase = 20 + (nivelFase * 5);
            
            Ciclope ciclope = new Ciclope(GeradorNomes.gerarnomerandom() + nivelFase, vidaBase, forcaBase, xpBase, 50.0 + (nivelFase * 10));
            fase.adicionarMonstro(ciclope);
            
            ProfessorDaFEM professor = new ProfessorDaFEM(GeradorNomes.gerarnomerandom() + nivelFase, vidaBase + 10, forcaBase - 2, xpBase + 5, 60.0 + (nivelFase * 5));
            fase.adicionarMonstro(professor);
        }
        
        Arqueira heroi = new Arqueira("Isabela", 150, 15, 1, 0, 100, 0.7, 0.8);
        Arma arco = new Arco("Arco", 5, 1);
        heroi.equiparArma(arco);
        
        System.out.println("STATUS INICIAL DO HERÓI:");
        heroi.exibirStatus();
        System.out.println();
        
        boolean heroiVivo = true;
        
        for (int i = 0; i < fases.size() && heroiVivo; i++) {
            Fase faseAtual = fases.get(i);
            
            
            System.out.println("O HERÓI ENTRA NA(O) " + faseAtual.getAmbiente() + " PARA ENFRENTAR 2 MONSTROS.");
            System.out.println();
            
            for (int j = 0; j < faseAtual.getMonstros().size() && heroiVivo; j++) {
                Monstro monstro = faseAtual.getMonstros().get(j);
                
                System.out.println("ENCONTRO COM " + monstro.nome.toUpperCase() + ".");
                monstro.exibirStatus();
                System.out.println();
                
                int turno = 1;
                while (heroi.estaVivo() && monstro.estaVivo()) {
                    System.out.println(" TURNO " + turno);
                    
                    System.out.println(heroi.atacar(monstro));
                    int danoHeroi = heroi.forca + (heroi.arma != null ? heroi.arma.dano : 0);
                    monstro.receberDano(danoHeroi);
                    System.out.println(monstro.nome + " sofreu " + danoHeroi + " de dano!");
                    
                    if (!monstro.estaVivo()) {
                        System.out.println(monstro.nome + " foi derrotado!");
                        heroi.ganharExperiencia(monstro.xpConcedido);
                        System.out.println(heroi.nome + " ganhou " + monstro.xpConcedido + " XP!");
                        break;
                    }
                    
                    System.out.println(monstro.atacar(heroi));
                    int danoMonstro = monstro.forca + (monstro.arma != null ? monstro.arma.dano : 0);
                    heroi.receberDano(danoMonstro);
                    System.out.println(heroi.nome + " sofreu " + danoMonstro + " de dano!");
                    
                    if (!heroi.estaVivo()) {
                        System.out.println(heroi.nome + " foi derrotado!");
                        heroiVivo = false;
                        break;
                    }
                    
                    System.out.println(" Status após o turno ");
                    heroi.exibirStatus();
                    monstro.exibirStatus();
                    System.out.println();
                    
                    turno++;
                }
                
                System.out.println();
            }
            
            if (heroiVivo) {
                System.out.println("FASE " + faseAtual.getNivel() + " CONCLUÍDA COM SUCESSO!");
                System.out.println("Status do herói após a fase:");
                heroi.exibirStatus();
                System.out.println();
            }
        }
        
        if (heroiVivo) {
            System.out.println("PARABÉNS! " + heroi.nome + " SOBREVIVEU A TODAS AS FASES!");
            System.out.println("STATUS FINAL DO HERÓI:");
            heroi.exibirStatus();
        } else {
            System.out.println("GAME OVER");
        }
    }
}