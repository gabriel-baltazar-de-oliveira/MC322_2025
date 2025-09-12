import java.util.ArrayList;
import java.util.Random;

public abstract class Monstro extends Personagem {
    protected int xpConcedido;
    protected ArrayList<Arma> listaDeArmasParaLargar = new ArrayList<>(); //adição

	//Construtor
    public Monstro(String nome, int vida, int forca, int xpConcedido) {
        super(nome, vida, forca);
        this.xpConcedido = xpConcedido;
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("XP concedido: " + xpConcedido);
    }


    public Arma largaArma() {
        if (listaDeArmasParaLargar.isEmpty()) return null;
        Random r = new Random();
        return listaDeArmasParaLargar.get(r.nextInt(listaDeArmasParaLargar.size()));
    }
}
