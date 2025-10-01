public enum TipoCenario {
    BAR("Bar divino da esquina") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Você recebe o nectar divino e recupera 10 pontos de vida!");
            heroi.receberCura(100);
        }
    },
    FACULDADE("Uma faculdade escura e úmida") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("A escuridão drena sua energia, você perde 5 pontos de vida!");
            heroi.receberDano(5);
        }
    },
    CASTELO("Um nobre castelo") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("Longe do ambiente estudantil você impõe respeito, sua força aumenta em +2!");
            heroi.setForca(heroi.getForca() + 2);
        }
    },
    CAMPO_DE_BATALHA("Um campo de batalha aberto") {
        @Override
        public void aplicarEfeitos(Heroi heroi) {
            System.out.println("O campo de batalha exige coragem! Herói recebe +5 de força!");
            heroi.setForca(heroi.getForca() + 5);
        }
    };

    protected final String descricao;

    TipoCenario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método abstrato que cada cenário deve implementar
    public abstract void aplicarEfeitos(Heroi heroi);
}
