public class Bruxa extends Heroi {
    private double sabedoria;

    // Construtor 
    public Bruxa(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel, double sorte, double sabedoria) {
        super(nome, pontosDeVida, forca, nivel, experiencia, expProximoNivel, sorte);
        this.sabedoria = sabedoria;
    }

    @Override
    public String atacar(Personagem alvo) { 
        return "Lança um feitiço no oponente.";
    }

    @Override
    public String usarHabilidadeEspecial(Personagem alvo) { 
        return "Descobre a fraqueza do oponente usando a sabedoria de " + sabedoria + " e lança feitiço correspondente.";
    }
}