public abstract class monstro extends personagem{
    //Atributo Adicional
    public double xpConcedido;

    //Construtor derivado de personagem
    public monstro(String nome, double pontosDeVida, double forca, double xpConcedido){
        super(nome, pontosDeVida, forca);
        this.xpConcedido = xpConcedido;
    }

    //Métodos
    @Override
    public String exibirStatus(){
        return "Nome: " + nome + ", pontos de Vida: " + pontosDeVida + ", força: " + forca
        + ", xpConcedido: " + xpConcedido;
    }
}
