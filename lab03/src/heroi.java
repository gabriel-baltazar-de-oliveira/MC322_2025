public abstract class heroi extends personagem {
    
    //Atributos Adicionais
    public double nivel;
    public double experiencia;
    
    //Construtor derivado de personagem
    public heroi(String nome, double pontosDeVida, double forca, double nivel, double experiencia){
        super(nome, pontosDeVida, forca);
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    //Métodos
    public double ganharExperiencia(double ganho){
        return experiencia = experiencia + ganho;
    }
    
    @Override
    public String exibirStatus(){
        return "Nome: " + nome + ", pontos de Vida: " + pontosDeVida + ", força: " + forca + 
        ", nível: " + nivel + ", experiência: " + experiencia;
    }

    //método abstrato usarHabilidadeEspecial
    public abstract String usarHabilidadeEspecial(personagem alvo);
}
