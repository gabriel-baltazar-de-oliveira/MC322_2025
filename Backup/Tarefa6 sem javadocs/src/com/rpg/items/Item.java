package com.rpg.items;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.HashMap;
import java.util.Map;

/**
 * Interface base para todos os itens.
 * ATUALIZADA com anotações Jackson para suportar múltiplos tipos de itens.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "@type"
)
@JsonSubTypes({
    // Lista de todas as classes concretas que podem ser um "Item"
    @JsonSubTypes.Type(value = Item.ItemConcreto.class, name = "itemConcreto"),
    @JsonSubTypes.Type(value = Arco.class, name = "arco"),
    @JsonSubTypes.Type(value = Espada.class, name = "espada"),
    @JsonSubTypes.Type(value = Varinha.class, name = "varinha")
})
public interface Item {
    
    String getNome();
    int getBonusForca();
    int getBonusVida();

    /**
     * Implementação concreta de um item genérico.
     */
    class ItemConcreto implements Item {
        private String nome;
        private int bonusForca;
        private int bonusVida;

        // Construtor vazio para Jackson
        public ItemConcreto() {} 
        
        public ItemConcreto(String nome, int bonusForca, int bonusVida) {
            this.nome = nome;
            this.bonusForca = bonusForca;
            this.bonusVida = bonusVida;
        }

        @Override public String getNome() { return this.nome; }
        @Override public int getBonusForca() { return this.bonusForca; }
        @Override public int getBonusVida() { return this.bonusVida; }

        // Getters e Setters para o Jackson funcionar corretamente ao carregar
        public void setNome(String nome) { this.nome = nome; }
        public void setBonusForca(int bonusForca) { this.bonusForca = bonusForca; }
        public void setBonusVida(int bonusVida) { this.bonusVida = bonusVida; }
    }

    /**
     * Fábrica de itens.
     */
    class GerenciadorItens {
        private static final Map<String, Item> ITENS_REGISTRADOS = new HashMap<>();
        static {
            ITENS_REGISTRADOS.put("ESPADA_BASICA", new ItemConcreto("Espada Básica", 5, 0));
            ITENS_REGISTRADOS.put("ARCO_SIMPLES", new ItemConcreto("Arco Simples", 3, 0));
            ITENS_REGISTRADOS.put("MACHADO_PESADO", new ItemConcreto("Machado Pesado", 8, -5));
            ITENS_REGISTRADOS.put("ESCUDO_MADEIRA", new ItemConcreto("Escudo de Madeira", 0, 15));
            ITENS_REGISTRADOS.put("POCAO_VIDA_PEQUENA", new ItemConcreto("Poção de Vida Pequena", 0, 20));
            ITENS_REGISTRADOS.put("VARINHA_INICIANTE", new ItemConcreto("Varinha de Aprendiz", 2, 5));
        }

        public static Item criarItem(String id) throws Exception {
            Item item = ITENS_REGISTRADOS.get(id);
            if (item == null) {
                throw new Exception("O item com o ID '" + id + "' não existe.");
            }
            return item;
        }
    }
}