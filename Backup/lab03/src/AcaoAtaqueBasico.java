public class AcaoAtaqueBasico implements AcaoDeCombate {
    @Override
    public void executar(Combatente usuario, Combatente alvo) {
        int dano = usuario.getForca();
        alvo.receberDano(dano);
        System.out.println(usuario.getNome() + " ataca " + alvo.getNome() + " causando " + dano + " de dano!");
    }
}
