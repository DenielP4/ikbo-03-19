package lab16;

public final class Drink implements Alcoholable {
    private double alcoholVol;
    private DrinkTypeEnum type;
    DrinkTypeEnum getType() {
        return type;
    }
    @Override
    public void isAlcoholicDrink(){}
    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }
}
