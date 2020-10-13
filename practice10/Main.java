package practice10;

public class Main {
    public static void main(String[] args) {
        Client c = new Client();
        c.setChair(new ChairFactory().createFunctionalChair());
        c.sit();
        c.setChair(new ChairFactory().createMagichair());
        c.sit();
        c.setChair(new ChairFactory().createVictorianChair());
        c.sit();
    }
}
