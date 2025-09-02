// Source code is decompiled from a .class file using FernFlower decompiler.
public class Paladino extends heroi {
   public String poderSagrado;
   public double fe;  // atributo único

   public Paladino(String nome, double pontosDeVida, double forca, double nivel, double experiencia, String poderSagrado, double fe) {
      super(nome, pontosDeVida, forca, nivel, experiencia);
      this.poderSagrado = poderSagrado;
      this.fe = fe;
   }

   @Override
   public String atacar(personagem alvo) {
      return "Golpeia o inimigo com sua espada sagrada.";
   }

   @Override
   public String usarHabilidadeEspecial(personagem alvo) {
      return "Invoca o poder sagrado " + this.poderSagrado + " com fé de " + this.fe + " para proteger os aliados.";
   }
}
