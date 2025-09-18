// Evento.java
public interface Evento {
    // verifica se o gatilho do evento ocorreu (ex: herói entrou na sala, HP < X, probabilidade, etc.)
    boolean verificarGatilho(Heroi heroi, Fase fase);

    // executa o efeito do evento (pode alterar herói, fase, monstros, etc.)
    void executar(Heroi heroi, Fase fase);
}
