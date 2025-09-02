// Source code is decompiled from a .class file using FernFlower decompiler.
public class Arqueira extends heroi {
   public String tipoDeFlecha;
   public double precisao;  // atributo único

   public Arqueira(String nome, double pontosDeVida, double forca, double nivel, double experiencia, String tipoDeFlecha, double precisao) {
      super(nome, pontosDeVida, forca, nivel, experiencia);
      this.tipoDeFlecha = tipoDeFlecha;
      this.precisao = precisao;
   }

   @Override
   public String atacar(personagem alvo) {
      return "Dispara uma flecha de " + this.tipoDeFlecha + " com precisão de " + this.precisao + " contra o inimigo.";
   }

   @Override
   public String usarHabilidadeEspecial(personagem alvo) {
      return "Executa um ataque especial com flechas múltiplas de " + this.tipoDeFlecha + " aumentando a precisão para " + this.precisao + ".";
   }
}
