package com.rpg.combate;

import com.rpg.items.Item;
import com.rpg.personagens.Monstro;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilitário para gerenciamento de loot durante combates.
 * 
 * <p>Coordena o sistema de recompensas pós-combate usando
 * o sistema de agregação de itens.</p>
 * 
 */
public class GerenciadorLoot {
    
    /**
     * Processa o loot de uma lista de monstros derrotados.
     * 
     * @param monstrosDerrotados Lista de monstros derrotados no combate
     * @return Lista de itens obtidos como loot
     */
    public static List<Item> processarLoot(List<Monstro> monstrosDerrotados) {
        List<Item> lootObtido = new ArrayList<>();
        
        for (Monstro monstro : monstrosDerrotados) {
            Item loot = monstro.droparLoot();
            if (loot != null) {
                lootObtido.add(loot);
            }
        }
        
        return lootObtido;
    }
    
    /**
     * Exibe o loot obtido de forma organizada.
     * 
     * @param loot Lista de itens obtidos
     */
    public static void exibirLoot(List<Item> loot) {
        if (loot.isEmpty()) {
            System.out.println("Nenhum item foi encontrado.");
            return;
        }
        
        System.out.println("\n=== LOOT OBTIDO ===");
        for (int i = 0; i < loot.size(); i++) {
            System.out.println((i + 1) + ". " + loot.get(i).getNome());
        }
    }
}