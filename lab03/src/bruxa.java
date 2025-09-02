public class bruxa extends heroi {
    // Atributos únicos
    public String feitico;
    public double sabedoria;  // atributo único

    // Construtor derivado de herói
    public bruxa(String nome, double pontosDeVida, double forca, double nivel, double experiencia, String feitico, double sabedoria){
        super(nome, pontosDeVida, forca, nivel, experiencia);
        this.feitico = feitico;
        this.sabedoria = sabedoria;
    }

    // Implementação métodos abstratos
    @Override
    public String atacar(personagem alvo){
        return "Lança o feitiço " + feitico + " no oponente, usando sabedoria de " + sabedoria + ".";
    }

    @Override
    public String usarHabilidadeEspecial(personagem alvo){
        return "Executa um feitiço poderoso aproveitando toda a sabedoria de " + sabedoria + ".";
    }
}
