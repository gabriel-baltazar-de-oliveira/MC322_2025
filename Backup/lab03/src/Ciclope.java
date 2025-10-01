import java.util.Arrays;

public class Ciclope extends Monstro {

    public Ciclope() {
        super("Ciclope", 200, 30, 70, Arrays.asList(new AcaoAtaqueBasico()));
    }

    @Override
    public void atacar(Personagem alvo) {
        acoes.get(0).executar(this, alvo);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 20;
        alvo.receberDano(dano);
        System.out.println(getNome() + " lançou ataque devastador em " + alvo.getNome() +
                           " causando " + dano + " de dano!");
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        AcaoDeCombate acao = acoes.get(0);
        acao.executar(this, (Personagem) alvo);
        return acao;
    }
}
