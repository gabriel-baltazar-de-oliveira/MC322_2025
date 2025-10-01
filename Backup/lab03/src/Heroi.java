import java.util.Arrays;
import java.util.List;

public class Heroi extends Personagem implements Combatente {

    private final List<AcaoDeCombate> acoes;

    public Heroi(String nome, int vidaMaxima, int forca) {
        super(nome, vidaMaxima, forca);
        // Inicializa a lista de ações com Ataque Básico
        this.acoes = Arrays.asList(new AcaoAtaqueBasico());
    }

    @Override
    public void atacar(Personagem alvo) {
        // Usa a primeira ação da lista
        acoes.get(0).executar(this, alvo);
    }
    
    public int getVidaAtual() {
        return this.pontosDeVida; // retorna o atributo de pontos de vida atual
    }
    @Override
    public void usarHabilidadeEspecial(Personagem alvo) {
        // Exemplo simples: dano extra
        int dano = getForca() + 10;
        alvo.receberDano(dano);
        System.out.println(getNome() + " usou habilidade especial em " + alvo.getNome() +
                           " causando " + dano + " de dano!");
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        // Retorna sempre a primeira ação
        AcaoDeCombate acao = acoes.get(0);
        acao.executar(this, (Personagem) alvo);
        return acao;
    }

    public List<AcaoDeCombate> getAcoes() {
        return acoes;
    }
}
