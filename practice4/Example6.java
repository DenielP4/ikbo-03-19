package practice4;

public class Example6 {
    public static void main(String[] args){
        example1(5);
        System.out.println("-------");
        example2(6);
        System.out.println("-------");
        example3(2,5);
    }
    public static void example1(int k){
        int k1 = 1;
        while(k1<=k){
            for(int i=0; i<k1; i++)
                System.out.println(k1);
            k1++;
        }
    }
    public static void example2(int n){
        for(int i=1; i<=n; i++)
            System.out.println(i);
    }
    public static void example3(int A, int B){
        if(A>B)
            for(int i=A; i<=B; i++)
                System.out.println(i);
        else if(B>A)
        for(int i=B; i>=A; i--)
            System.out.println(i);
    }
}
