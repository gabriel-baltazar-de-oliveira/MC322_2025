package com.rpg.personagens;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rpg.items.Item;
import com.rpg.items.Item.GerenciadorItens;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe base abstrata para todos os monstros do jogo.
 * Herda de Personagem e adiciona lógica de drops.
 * ATUALIZADA com anotações Jackson.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "@type" // Nome do campo que guardará a "etiqueta" no JSON
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Ciclope.class, name = "ciclope"),
    @JsonSubTypes.Type(value = ElefantePsiquico.class, name = "elefantePsiquico"),
    @JsonSubTypes.Type(value = ProfessorDaFEM.class, name = "professorDaFEM")
})
public abstract class Monstro extends Personagem {

    protected double chanceDrop;
    protected List<String> possiveisDrops;
    private static final Random random = new Random();

    public Monstro(String nome, int vidaMaxima, int forca) {
        super(nome, vidaMaxima, forca);
        this.chanceDrop = 0.2;
        this.possiveisDrops = new ArrayList<>();
    }
    
    // O resto da classe continua igua
    
    public void setChanceDrop(double chanceDrop) {
        this.chanceDrop = chanceDrop;
    }

    public void adicionarPossivelDrop(String idItem) {
        this.possiveisDrops.add(idItem);
    }
    
    public List<String> getPossiveisDrops() {
        return possiveisDrops;
    }

    public Item droparLoot() {
        if (random.nextDouble() <= this.chanceDrop) {
            if (possiveisDrops == null || possiveisDrops.isEmpty()) {
                return null;
            }
            int indiceSorteado = random.nextInt(possiveisDrops.size());
            String idItemSorteado = possiveisDrops.get(indiceSorteado);
            try {
                return GerenciadorItens.criarItem(idItemSorteado);
            } catch (Exception e) {
                System.out.println("Erro ao criar loot: " + e.getMessage());
                return null;
            }
        }
        return null; 
    }
}