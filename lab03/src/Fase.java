import java.util.ArrayList;

public class Fase {
    private int nivel;
    private String ambiente;
    private ArrayList<Monstro> monstros = new ArrayList<>();

    public Fase(int nivel) {
        this.nivel = nivel;
        this.ambiente = definirAmbiente(nivel);
    }

    private String definirAmbiente(int numeroFase) {
        int resto = numeroFase % 3;
        switch (resto) {
            case 0: return "campo";
            case 1: return "floresta";
            case 2: return "montanha";
            default: return "campo"; 
        }
    }

    public void adicionarMonstro(Monstro monstro) {
        monstros.add(monstro);
    }

    // ADICIONAR GETTERS
    public int getNivel() { return nivel; }
    public String getAmbiente() { return ambiente; }
    public ArrayList<Monstro> getMonstros() { return monstros; }
}