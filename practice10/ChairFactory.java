package practice10;

public class ChairFactory implements AbstractChairFactory {


    @Override
    public VictorianChair createVictorianChair() {
        return new VictorianChair((int) Math.random());
    }

    @Override
    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }

    @Override
    public MagicChair createMagichair() {
        return new MagicChair();
    }
}
