package com.rpg.game;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Classe responsável por salvar e carregar o estado de uma Batalha usando JAXB.
 * Métodos estáticos:
 *  - salvarBatalha(Batalha b, String nomeBatalha)
 *  - carregarBatalha(String nomeBatalha)
 *
 * Os arquivos XML são salvos na pasta "saved_games".
 */
public class GerenciadorDePersistencia {

    private static final String SAVE_DIR = "saved_games";

    /**
     * Salva o objeto Batalha em um arquivo XML dentro da pasta "saved_games".
     */
    public static void salvarBatalha(Batalha b, String nomeBatalha) {
        try {
            File dir = new File(SAVE_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(dir, nomeBatalha + ".xml");

            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(b, file);

            System.out.println("Batalha salva com sucesso em: " + file.getAbsolutePath());
        } catch (JAXBException e) {
            System.err.println("Erro ao salvar a batalha: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Carrega uma Batalha salva a partir de um arquivo XML.
     * Retorna a instância de Batalha carregada.
     */
    public static Batalha carregarBatalha(String nomeBatalha) {
        try {
            File file = new File(SAVE_DIR, nomeBatalha + ".xml");
            if (!file.exists()) {
                System.err.println("Arquivo de save não encontrado: " + file.getAbsolutePath());
                return null;
            }

            JAXBContext context = JAXBContext.newInstance(Batalha.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Batalha batalha = (Batalha) unmarshaller.unmarshal(file);

            System.out.println("Batalha carregada com sucesso de: " + file.getAbsolutePath());
            return batalha;
        } catch (JAXBException e) {
            System.err.println("Erro ao carregar a batalha: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
