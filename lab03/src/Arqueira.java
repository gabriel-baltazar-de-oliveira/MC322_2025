public class Arqueira extends Heroi {
   private double precisao;

    public Arqueira(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel, double sorte, double precisao) {
        super(nome, pontosDeVida, forca, nivel, experiencia, expProximoNivel, sorte);
        this.precisao = precisao;
    }
    
    @Override
    public String atacar(Personagem alvo) { 
        return "Dispara uma flecha contra o inimigo.";
    }

    @Override
    public String usarHabilidadeEspecial(Personagem alvo) { 
        return "Executa um ataque especial com flechas múltiplas em sequência com precisão de " + this.precisao + ".";
    }
}