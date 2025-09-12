public class Paladino extends Heroi {
    private final int fe; // atributo único
    private final String poderSagrado;

    public Paladino(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel, double sorte, int fe, String poderSagrado) {
       super(nome, pontosDeVida, forca, nivel, experiencia, expProximoNivel, sorte);
        this.fe = fe;
        this.poderSagrado = poderSagrado;
    }

    @Override
    public String atacar(Personagem alvo) {
        alvo.receberDano(forca);
        return nome + " golpeia o alvo com a espada sagrada!";
    }

    @Override
    public String usarHabilidadeEspecial(Personagem alvo) {
        int dano = forca + fe * 2;
        alvo.receberDano(dano);
        return nome + " invoca o poder sagrado " + poderSagrado + " causando " + dano + " de dano em " + alvo.nome;
    }
}
