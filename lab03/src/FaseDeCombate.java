import java.util.List;

public class FaseDeCombate implements Fase { 
    private final List<Monstro> monstros;
    private final TipoCenario cenario;
    private boolean concluida = false;

    public FaseDeCombate(List<Monstro> monstros, TipoCenario cenario) {
        this.monstros = monstros;
        this.cenario = cenario;
    }

    // Implementa o método da interface Fase (retorna String, não TipoCenario)
    @Override
    public String getTipoDeCenario() {
        return cenario.name(); // converte enum para String
    }

    @Override
    public String getDescricion() {
        return cenario.getDescricao(); 
    }


    // Implementa o método isConcluida exigido pela interface
    @Override
    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public List<Monstro> getMonstros() {
        return monstros;
    }

    public void aplicarEfeitos(Heroi heroi) {
        cenario.aplicarEfeitos(heroi); 
    }

    public void iniciar(Heroi heroi) {
        System.out.println("Fase de combate iniciada para o herói " + heroi.getNome());
    }
}
