// GeradorDeFases.java
import java.util.List;

public interface GeradorDeFases {
    // cria e devolve uma lista de fases (com dificuldade crescente)
    List<Fase> gerar(int quantidadeDeFases);
}
