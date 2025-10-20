package com.rpg.cenario;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.rpg.personagens.Heroi;
import com.rpg.personagens.Monstro;
import java.util.List;

/**
 * Interface que define uma fase no sistema de RPG.
 * ATUALIZADA com anotações Jackson para suportar múltiplos tipos de fase.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "@type" // Campo que identifica o tipo de fase no JSON
)
@JsonSubTypes({
    // Lista de todas as classes concretas que podem ser uma "Fase"
    @JsonSubTypes.Type(value = FaseDeCombate.class, name = "combate")
    // Se no futuro você criar uma FaseDePuzzle, adicionaria ela aqui.
})
public interface Fase {
    
    void iniciar(Heroi heroi);
    
    boolean isConcluida();

    // Renomeei getTipoCenario para getTipoDeCenario para consistência
    TipoCenario getTipoDeCenario(); 
    
    // Corrigido o nome do método de "getDescricion" para "getDescricao"
    String getDescricao(); 
    
    List<Monstro> getMonstros();

    // Adicionado um setter para o Jackson poder definir a conclusão ao carregar
    void setConcluida(boolean concluida);
}