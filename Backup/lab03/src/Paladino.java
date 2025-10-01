public class Paladino extends Heroi {
    private final int fe; // atributo único
    private final String poderSagrado;

    public Paladino(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel, double sorte, int fe, String poderSagrado) {
        super(nome, pontosDeVida, forca);
        this.fe = fe;
        this.poderSagrado = poderSagrado;
    }

    @Override
    public void atacar(Personagem alvo) {
        // usa a força do herói para atacar
        alvo.receberDano(getForca());
        System.out.println(getNome() + " golpeia o alvo com a espada sagrada!");
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + fe * 2;
        alvo.receberDano(dano);
        System.out.println(getNome() + " invoca o poder sagrado " + poderSagrado + " causando " + dano + " de dano em " + alvo.getNome());
    }
}
