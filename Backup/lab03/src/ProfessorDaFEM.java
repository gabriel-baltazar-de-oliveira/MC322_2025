import java.util.Arrays;

public class ProfessorDaFEM extends Monstro {

    public ProfessorDaFEM() {
        super("ProfessorDaFEM", 100, 20, 50, Arrays.asList(new AcaoAtaqueBasico()));
    }

    @Override
    public void atacar(Personagem alvo) {
        acoes.get(0).executar(this, alvo);
    }

    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        int dano = getForca() + 10;
        alvo.receberDano(dano);
        System.out.println(getNome() + " usou habilidade especial em " + alvo.getNome() +
                           " causando " + dano + " de dano!");
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // Retorna a primeira ação e já executa
        AcaoDeCombate acao = acoes.get(0);
        acao.executar(this, (Personagem) alvo);
        return acao;
    }
}
