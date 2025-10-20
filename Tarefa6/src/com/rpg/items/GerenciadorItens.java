package com.rpg.items;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Gerenciador centralizado para itens do jogo.
 * 
 * <p>Implementa o padrão de agregação para itens, permitindo que
 * monstros compartilhem referências a classes de itens em vez de
 * instâncias específicas.</p>
 * 
 */
public class GerenciadorItens {
    
    private static final Map<String, Class<? extends Item>> itensRegistrados = new HashMap<>();
    private static final Random random = new Random();
    
    static {
        // Classes de itens disponívei no jogo
        registrarItem("ESPADA_BASICA", Espada.class);
        registrarItem("ARCO_SIMPLES", Arco.class);
        registrarItem("VARINHA_INICIANTE", Varinha.class);
    }
    
    /**
     * Registra uma clase de item para uso no sistema de loot.
     * 
     * @param chave Chave única para o item
     * @param classeItem Classe do item a ser registrada
     */
    public static void registrarItem(String chave, Class<? extends Item> classeItem) {
        itensRegistrados.put(chave, classeItem);
    }
    
    /**
     * Cria uma instância de item baseado na chave.
     * 
     * @param chave Chave do item desejado
     * @return Nova instância do item
     * @throws RuntimeException Se não for possível instaciar o item
     */
    public static Item criarItem(String chave) {
        Class<? extends Item> classeItem = itensRegistrados.get(chave);
        if (classeItem == null) {
            throw new IllegalArgumentException("Item não registrado: " + chave);
        }
        
        try {
            // Lógica de criação baseada no tipo de item
            if (classeItem.equals(Espada.class)) {
                return new Espada("Espada do Aventureiro", 10, 1);
            } else if (classeItem.equals(Arco.class)) {
                return new Arco("Arco de Caça", 8, 1);
            } else if (classeItem.equals(Varinha.class)) {
                return new Varinha("Varinha do Aprendiz", 12, 1);
            } else {
                // Fallback para criação genérica
                return classeItem.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar item: " + chave, e);
        }
    }
    
    /**
     * Retorna um item aleatório da lista de itens registrados.
     * 
     * @return Item aleatório ou null se não houver itens
     */
    public static Item getItemAleatorio() {
        if (itensRegistrados.isEmpty()) {
            return null;
        }
        
        String[] chaves = itensRegistrados.keySet().toArray(new String[0]);
        String chaveAleatoria = chaves[random.nextInt(chaves.length)];
        return criarItem(chaveAleatoria);
    }
    
    /**
     * Retorna todas as chaves de itens disponíveis.
     * 
     * @return Array com chaves dos itens registrados
     */
    public static String[] getItensDisponiveis() {
        return itensRegistrados.keySet().toArray(new String[0]);
    }
}