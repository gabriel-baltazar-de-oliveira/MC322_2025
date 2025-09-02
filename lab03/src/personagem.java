public abstract class personagem {
    //Atributos
    public String nome;
    public double pontosDeVida;
    public double forca;

    //Construtor
    public personagem(String nome, double pontosDeVida, double forca){
        this.nome = nome;
        this.pontosDeVida = pontosDeVida;
        this.forca = forca;
    }

    //Métodos
    public double receberDano(double dano){
        return pontosDeVida = pontosDeVida - dano;
    }

    public String exibirStatus(){
        return "Nome: " + nome + ", pontos de Vida: " + pontosDeVida + ", força: " + forca;
    }

    //método abstrato atacar
    public abstract String atacar(personagem alvo);
}




