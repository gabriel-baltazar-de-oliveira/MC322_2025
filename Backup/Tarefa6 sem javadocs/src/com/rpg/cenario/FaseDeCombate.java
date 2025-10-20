package com.rpg.cenario;

import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import java.util.List;

/**
 * Implementação concreta de uma Fase, focada em combate.
 */
public class FaseDeCombate implements Fase {

    private List<Monstro> monstros;
    private boolean concluida;
    private TipoCenario tipoDeCenario;
    private String descricao;

    // Construtor para criar a fase durante o jogo
    public FaseDeCombate(List<Monstro> monstros, TipoCenario tipo, String descricao) {
        this.monstros = monstros;
        this.tipoDeCenario = tipo;
        this.descricao = descricao;
        this.concluida = false;
    }

    // Construtor vazio que o Jackson usa para carregar o jogo
    private FaseDeCombate() {}

    // --- Implementação dos métodos da interface Fase ---

    @Override
    public void iniciar(Heroi heroi) {
        System.out.println("Iniciando fase de combate em: " + this.descricao);
        // Lógica de início de fase, como aplicar efeitos de cenário
        if (this.tipoDeCenario != null) {
            this.tipoDeCenario.aplicarEfeitos(heroi);
        }
    }

    @Override
    public boolean isConcluida() {
        return this.concluida;
    }

    @Override
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    
    @Override
    public TipoCenario getTipoDeCenario() {
        return this.tipoDeCenario;
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public List<Monstro> getMonstros() {
        return this.monstros;
    }
}