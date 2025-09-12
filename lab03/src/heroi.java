public abstract class Heroi extends Personagem {
    protected int nivel;
    protected int experiencia;
    protected int expProximoNivel;
    protected double sorte;

    // Construtor
    public Heroi(String nome, int pontosDeVida, int forca, int nivel, int experiencia, int expProximoNivel, double sorte) {
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.expProximoNivel = expProximoNivel;
        this.sorte = sorte;
    }

public void ganharExperiencia(int xp) {
    experiencia += xp;

    while (experiencia >= expProximoNivel) {
        experiencia -= expProximoNivel; // desconta o que foi usado para subir
        subirDeNivel();
    }
}


    private void subirDeNivel() {
        nivel = nivel + 1;
        expProximoNivel = expProximoNivel + 50;
        forca = forca + 5;
        pontosDeVida = pontosDeVida + 20;
    }

    public void equiparArma(Arma nova) {
        if (nivel >= nova.minNivel) {
            arma = nova;
            System.out.println(nome + " equipou " + nova.nome);
        } else {
            System.out.println(nome + " não tem nível para usar " + nova.nome);
        }
    }

    @Override
    public void exibirStatus() {
        super.exibirStatus();
        System.out.println("Nível: " + nivel + " | XP: " + experiencia + "/" + expProximoNivel + " | Sorte: " + sorte);
    }

    public abstract String usarHabilidadeEspecial(Personagem alvo);
}