public abstract class Arma {
    protected String nome;
    protected int dano;
    protected int minNivel;

	//Construtor
    public Arma(String nome, int dano, int minNivel) {
        this.nome = nome;
        this.dano = dano;
        this.minNivel = minNivel;
    }

}
