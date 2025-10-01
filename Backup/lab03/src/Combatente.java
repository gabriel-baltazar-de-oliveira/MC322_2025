public interface Combatente {
    String getNome();
    int getForca();
    boolean estaVivo();
    void  atacar(Personagem alvo);
    void usarHabilidadeEspecial(Personagem alvo);
    void receberDano(int dano);
    void receberCura(int cura);
    AcaoDeCombate escolherAcao(Combatente alvo);
}
