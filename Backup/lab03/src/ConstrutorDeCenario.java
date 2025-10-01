/* 
import java.util.ArrayList;

public class ConstrutorDeCenario {
    
    // Método estático
    public static ArrayList<Fase> gerarFases(int n) {
        ArrayList<Fase> fases = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            Fase fase = new Fase(i); // Agora só passa o nível, ambiente é definido automaticamente
            fases.add(fase);
        }
        return fases;
    }
}
*/