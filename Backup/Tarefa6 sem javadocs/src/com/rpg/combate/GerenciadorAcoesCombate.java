package com.rpg.combate;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerenciador centralizado para ações de combate compartilhadas.
 * 
 * <p>Implementa o padrão de reuso para garantir que ações idênticas
 * sejam compartilhadas entre todos os combatentes, seguindo o
 * princípio de agregação correta.</p>
 * 
 * @author RPG Development Team
 * @version 1.0
 */
public class GerenciadorAcoesCombate {
    
    private static final Map<String, AcaoDeCombate> acoes = new HashMap<>();
    
    static {
        // Inicializa as ações básicas compartilhadas
        acoes.put("ATAQUE_BASICO", new AcaoAtaqueBasico());
        acoes.put("HABILIDADE_FORTE", new AcaoHabilidadeEspecial("Ataque Poderoso", 15));
        acoes.put("HABILIDADE_FRACA", new AcaoHabilidadeEspecial("Golpe Rápido", 8));
    }
    
    /**
     * Retorna uma ação de combate compartilhada pelo tipo.
     * 
     * <p>Garante que a mesma instância seja reutilizada por todos
     * os combatentes que precisam da mesma ação.</p>
     *
     * @param tipoAcao Tipo da ação desejada
     * @return Instância compartilhada da ação
     * @throws IllegalArgumentException Se o tipo de ação não existir
     */
    public static AcaoDeCombate getAcao(String tipoAcao) {
        AcaoDeCombate acao = acoes.get(tipoAcao);
        if (acao == null) {
            throw new IllegalArgumentException("Ação não encontrada: " + tipoAcao);
        }
        return acao;
    }
    
    /**
     * Registra uma nova ação para compartilhamento.
     * 
     * @param chave Chave única para a ação
     * @param acao Ação a ser compartilhada
     */
    public static void registrarAcao(String chave, AcaoDeCombate acao) {
        acoes.put(chave, acao);
    }
    
    /**
     * Retorna todas as ações disponíveis.
     * 
     * @return Array com as chaves das ações disponíveis
     */
    public static String[] getAcoesDisponiveis() {
        return acoes.keySet().toArray(new String[0]);
    }
}