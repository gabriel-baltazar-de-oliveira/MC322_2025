package com.rpg.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Gerenciador responsável por salvar e carregar o estado do jogo.
 *
 * <p>Utiliza a biblioteca Jackson para serialização em JSON, permitindo
 * que objetos complexos como Batalha sejam salvos e carregados
 * de forma transparente e moderna.</p>
 *
 * @author RPG Development Team
 * @version 2.0
 */
public class GerenciadorDePersistencia {

    private static final String PASTA_SAVES = "saves/";
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        // Configura o ObjectMapper para "embelezar" o arquivo JSON, facilitando a leitura
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Salva uma batalha em um arquivo JSON.
     */
    public static void salvarBatalha(Batalha batalha, String nomeBatalha) {
        try {
            Files.createDirectories(Paths.get(PASTA_SAVES));

            String arquivoPath = PASTA_SAVES + nomeBatalha + ".json";
            File arquivo = new File(arquivoPath);

            // A mágica do Jackson: converte o objeto 'batalha' para JSON e salva no arquivo
            mapper.writeValue(arquivo, batalha);

            System.out.println("Jogo salvo com sucesso: " + arquivoPath);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar o jogo (serialização ou IO): " + e.getMessage(), e);
        }
    }

    /**
     * Carrega uma batalha de um arquivo JSON.
     */
// Dentro de GerenciadorDePersistencia.java

/**
 * Carrega uma batalha de um arquivo JSON.
 * VERSÃO DE DEPURAÇÃO: Imprime o erro completo do Jackson.
 */
public static Batalha carregarBatalha(String nomeBatalha) {
    String arquivoPath = PASTA_SAVES + nomeBatalha + ".json";
    File arquivo = new File(arquivoPath);

    if (!arquivo.exists()) {
        System.out.println("Arquivo de save não encontrado: " + arquivoPath);
        return null; // Retornamos null aqui para simplificar
    }

    try {
        Batalha batalha = mapper.readValue(arquivo, Batalha.class);
        System.out.println("Jogo carregado com sucesso: " + arquivoPath);
        return batalha;

    } catch (Exception e) { // Mudei para pegar QUALQUER exceção
        System.out.println("\n\n--- ERRO DETALHADO DO JACKSON ---");
        e.printStackTrace(); // <<<<<<< ESTA LINHA É A MAIS IMPORTANTE
        System.out.println("---------------------------------\n\n");
        
        // Vamos lançar uma nova exceção para parar o jogo e garantir que a gente veja a mensagem.
        throw new RuntimeException("Ocorreu um erro detalhado durante o carregamento. Veja o log acima.", e);
    }
}

    /**
     * Verifica se existem jogos salvos.
     */
    public static boolean existemJogosSalvos() {
        File pasta = new File(PASTA_SAVES);
        if (!pasta.exists() || !pasta.isDirectory()) {
            return false;
        }

        File[] arquivos = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
        return arquivos != null && arquivos.length > 0;
    }

    /**
     * Lista todos os jogos salvos disponíveis, do mais recente para o mais antigo.
     */
    public static String[] listarJogosSalvos() {
        File pasta = new File(PASTA_SAVES);
        if (!pasta.exists() || !pasta.isDirectory()) {
            return new String[0];
        }

        File[] arquivos = pasta.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
        if (arquivos == null || arquivos.length == 0) {
            return new String[0];
        }

        // Ordena os arquivos pela data de modificação (mais recente primeiro)
        Arrays.sort(arquivos, Comparator.comparingLong(File::lastModified).reversed());

        String[] nomes = new String[arquivos.length];
        for (int i = 0; i < arquivos.length; i++) {
            String nomeCompleto = arquivos[i].getName();
            // Remove a extensão ".json" (5 caracteres)
            nomes[i] = nomeCompleto.substring(0, nomeCompleto.length() - 5);
        }

        return nomes;
    }
}