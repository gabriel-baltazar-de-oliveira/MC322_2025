public class Bruxa extends Heroi {
    private final int inteligencia;
    private final String nomeFeitico;

    public Bruxa(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel, double sorte, int inteligencia, String nomeFeitico) {
        super(nome, pontosDeVida, forca);
        this.inteligencia = inteligencia;
        this.nomeFeitico = nomeFeitico;
    }

    @Override
    public void atacar(Personagem alvo) {
        int dano = getForca();
        alvo.receberDano(dano);
        System.out.println(getNome() + " ataca o alvo com magia causando " + dano + " de dano!");
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + inteligencia * 2;
        alvo.receberDano(dano);
        System.out.println(getNome() + " lança o feitiço " + nomeFeitico + " causando " + dano + " de dano em " + alvo.getNome());
    }
}
