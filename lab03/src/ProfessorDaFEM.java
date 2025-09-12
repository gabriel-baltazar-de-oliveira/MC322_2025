public class ProfessorDaFEM extends Monstro {
    private double temor;

    public ProfessorDaFEM(String nome, int pontosDeVida, int forca, int xpConcedido, double temor) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.temor = temor;
        
        listaDeArmasParaLargar.add(new Avaliacao("Avaliação Difícil", 8, 2));
    }

    @Override
    public String atacar(Personagem alvo) {
        return "O Professor da FEM lança uma prova impossível em " + alvo.nome + ", causando temor de " + temor + "!";
    }
}