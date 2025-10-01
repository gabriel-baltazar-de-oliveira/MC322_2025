import java.util.Arrays;

public class ElefantePsíquico extends Monstro {

    public ElefantePsíquico() {
        super("ElefantePsíquico", 150, 25, 60, Arrays.asList(new AcaoAtaqueBasico()));
    }

    @Override
    public void atacar(Personagem alvo) {
        acoes.get(0).executar(this, alvo);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 15;
        alvo.receberDano(dano);
        System.out.println(getNome() + " usou ataque psíquico em " + alvo.getNome() +
                           " causando " + dano + " de dano!");
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        AcaoDeCombate acao = acoes.get(0);
        acao.executar(this, (Personagem) alvo);
        return acao;
    }
}
