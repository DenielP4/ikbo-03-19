package lab10;

public class Main {
    public static void main(String[] args) {
        SuperArray<Object>sa1=new SuperArray<Object>();
        Object a[]= new Object[3];
        a[1]="string";
        a[2]=1;
        a[0]=0;
        sa1.setA(a);
        System.out.println(sa1.getArrIndex(1));
    }
}
