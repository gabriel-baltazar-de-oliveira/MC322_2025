public abstract class Personagem {
    protected String nome;
    protected int pontosDeVida;
    protected int forca;
    protected Arma arma;

    // Construtor
    public Personagem(String nome, int pontosDeVida, int forca) { // Removido Arma arma
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
        this.arma = null;
    }

    public boolean estaVivo() {
        return pontosDeVida > 0;
    }

    public void receberDano(int dano) {
        pontosDeVida = pontosDeVida - dano;
    }

    public void exibirStatus() {
        
        System.out.println("Nome: " + nome + " | Pontos de vida: " + pontosDeVida + " | Força: " + forca);
        if (arma != null) {
            System.out.println("Arma: " + arma.nome + " (com dano extra: " + arma.dano + ")");
        } else {
            System.out.println("Arma: nenhuma");
        }
    }

    public abstract String atacar(Personagem alvo); 
}