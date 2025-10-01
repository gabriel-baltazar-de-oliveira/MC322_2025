import java.util.ArrayList;
import java.util.List;

public class ConstrutorDeCenarioFixo implements GeradorDeFases {

    @Override
    public List<Fase> gerar(int numeroDeFases) {
        List<Fase> fases = new ArrayList<>();

        // Fase 1: Ciclope no Bar
        List<Monstro> monstrosFase1 = new ArrayList<>();
        monstrosFase1.add(new Ciclope());
        fases.add(new FaseDeCombate(monstrosFase1, TipoCenario.BAR));

        // Fase 2: ProfessorDaFEM no Castelo
        List<Monstro> monstrosFase2 = new ArrayList<>();
        monstrosFase2.add(new ProfessorDaFEM());
        fases.add(new FaseDeCombate(monstrosFase2, TipoCenario.CASTELO));

        // Fase 3: ElefantePsíquico na Faculdade
        List<Monstro> monstrosFase3 = new ArrayList<>();
        monstrosFase3.add(new ElefantePsíquico());
        fases.add(new FaseDeCombate(monstrosFase3, TipoCenario.FACULDADE));

        return fases;
    }
}
