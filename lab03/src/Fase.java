import java.util.ArrayList;
import java.util.List;

public class Fase {
    private final int nivel;
    private final String ambiente;
    private final List<monstro> monstros;

    // Construtor
    public Fase(int nivel, String ambiente, List<monstro> monstrosBase) {
        this.nivel = nivel;
        this.ambiente = ambiente;
        this.monstros = new ArrayList<>();

        // Escala a dificuldade de acordo com o nível
        for (monstro m : monstrosBase) {
            monstro monstroEscalado = escalarMonstro(m, nivel);
            this.monstros.add(monstroEscalado);
        }
    }

    // Método privado para aumentar dificuldade
    private monstro escalarMonstro(monstro original, int nivel) {
        // Aumenta vida e força proporcionalmente ao nível
        double novaVida = original.pontosDeVida + (nivel * 10);
        double novaForca = original.forca + (nivel * 2);

        // Clona o monstro de acordo com a classe original
        if (original instanceof Ciclope c) {
            return new Ciclope(c.nome, novaVida, novaForca, c.xpConcedido, c.furia);
        } else if (original instanceof ProfessorDaFEM p) {
            return new ProfessorDaFEM(p.nome, novaVida, novaForca, p.xpConcedido, p.temor);
        } else if (original instanceof ElefantePsíquico e) {
            return new ElefantePsíquico(e.nome, novaVida, novaForca, e.xpConcedido, e.poderMental);
        }

        // Se não for nenhum dos conhecidos, devolve o original
        return original;
    }

    // Métodos de acesso
    public int getNivel() {
        return nivel;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public List<monstro> getMonstros() {
        return monstros;
    }

    // Método para exibir informações da fase
    public void exibirFase() {
        System.out.println("=== FASE " + nivel + " ===");
        System.out.println("Cenário: " + ambiente);
        System.out.println("Monstros desta fase:");
        for (monstro m : monstros) {
            System.out.println("- " + m.exibirStatus());
        }
        System.out.println("=====================\n");
    }
}
