public class ElefantePsíquico extends monstro {
    public double poderMental;  // atributo único

    public ElefantePsíquico(String nome, double pontosDeVida, double forca, double xpConcedido, double poderMental) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.poderMental = poderMental;
    }

    @Override
    public String atacar(personagem alvo) {
        return "O Elefante Psíquico ataca " + alvo.nome + " com ondas mentais poderosas de intensidade " + poderMental + "!";
    }
}
