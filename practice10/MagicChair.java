package practice10;

public class MagicChair extends ChairFactory implements Chair{
    public void doMagic(){
        System.out.println("Магия");
    }

    @Override
    public String toString() {
        return "MagicChair{}";
    }
}
