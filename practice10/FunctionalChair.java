package practice10;

public class FunctionalChair extends ChairFactory implements Chair {
    int sum(int a,int b){
        return a+b;
    }

    @Override
    public String toString() {
        return "FunctionalChair{}";
    }
}
