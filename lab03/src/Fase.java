// Fase.java

public interface Fase {
    // inicia a fase com o herói (pode preparar monstros, eventos, etc.)
    void iniciar(Heroi heroi);

    // retorna true quando os objetivos da fase forem cumpridos
    boolean isConcluida();

    // descreve o tipo/ambiente do cenário (ex: "Catacumbas", "Ruínas")
    String getTipoDeCenario();
    String getDescricion();
    public Iterable<Monstro> getMonstros();
}
