public class ElefantePsíquico extends Monstro {
    private final int poderMental;

    public ElefantePsíquico(String nome, int pontosDeVida, int forca, int xpConcedido, int poderMental) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.poderMental = poderMental;
    }

    @Override
    public String atacar(Personagem alvo) {
        int dano = forca + poderMental;
        alvo.receberDano(dano);
        return nome + " usa poderes psíquicos contra " + alvo.nome + " causando " + dano + " de dano!";
    }
}
