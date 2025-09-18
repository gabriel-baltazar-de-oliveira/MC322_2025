import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Monstro extends Personagem implements Lootavel {
    protected int xpConcedido;
    protected  final List<AcaoDeCombate> acoes;

    public Monstro(String nome, int pontosDeVida, int forca, int xpConcedido, List<AcaoAtaqueBasico> list) {
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
        this.acoes = new ArrayList<>();

        // Exemplo: todo monstro começa com ataque básico
        this.acoes.add(new AcaoAtaqueBasico());
    }

    @Override
    public AcaoDeCombate escolherAcao(Combatente alvo) {
        Random rand = new Random();
        return acoes.get(rand.nextInt(acoes.size())); // IA aleatória simples
    }
    
    public int getVidaAtual() {
        return this.pontosDeVida; // retorna o atributo de pontos de vida atual
    }

    public void adicionarAcao(AcaoDeCombate acao) {
        acoes.add(acao);
    }

    @Override
    public Item droparLoot() {
        // Aqui você deve usar um Item já existente no seu projeto.
        // Exemplo: suponha que exista a classe Espada que estende Arma.
        return new Espada("Espada Enferrujada", 3,3);
    }

    public int getXpConcedido() {
        return xpConcedido;
    }
}
