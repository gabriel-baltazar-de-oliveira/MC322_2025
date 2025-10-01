import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeradorNomes {

    private static final Random random = new Random();

    // Listas de nomes possíveis
    private static final List<String> nomesaleatorios = Arrays.asList(
        "Scot ", "Professor de Vibrações ", "Amendoin ", "Olho roxo ", "JLS"
    );


    // Gera um nome aleatório para Ciclope
    public static String gerarnomerandom() {
        return nomesaleatorios.get(random.nextInt(nomesaleatorios.size()));
    }

    // Método genérico para qualquer lista de nomes
    public static String gerarNomeAleatorio(List<String> nomes) {
        return nomes.get(random.nextInt(nomes.size()));
    }
}
