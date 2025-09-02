public class ProfessorDaFEM extends monstro {
    public double temor;  // atributo único

    public ProfessorDaFEM(String nome, double pontosDeVida, double forca, double xpConcedido, double temor) {
        super(nome, pontosDeVida, forca, xpConcedido);
        this.temor = temor;
    }

    @Override
    public String atacar(personagem alvo) {
        return "O Professor da FEM lança uma prova impossível em " + alvo.nome + ", causando temor de " + temor + "!";
    }
}
