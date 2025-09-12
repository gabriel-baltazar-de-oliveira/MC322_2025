public class Ciclope extends Monstro {
    private double calor;

    public Ciclope(String nome, int pontosDeVida, int forca, int xpConcedido, double calor) { // Corrigido parâmetro
        super(nome, pontosDeVida, forca, xpConcedido);
        this.calor = calor; 
        
        listaDeArmasParaLargar.add(new Laser("Laser Ocular", 12, 2));
    }

    @Override
    public String atacar(Personagem alvo) { 
        return "O Ciclope ataca " + alvo.nome + " atirando laser pelo olho com calor de " + calor + "!";
    }
}