public class Ciclope extends monstro {
    public double furia;  // atributo único

    public Ciclope(String nome, double pontosDeVida, double forca, double xpConcedido, double furia) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.furia = furia;
    }

    @Override
    public String atacar(personagem alvo) {
        return "O Ciclope ataca " + alvo.nome + " com seu soco devastador, com fúria de " + furia + "!";
    }
}
