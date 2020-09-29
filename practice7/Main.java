package practice7;

import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) {
        ArrayDeque a1=new ArrayDeque(5);
        ArrayDeque a2=new ArrayDeque(5);
        a1.add(1);
        a1.add(5);
        a1.add(2);
        a1.add(5);
        a1.add(2);
        a2.add(2);
        a2.add(4);
        a2.add(2);
        a2.add(8);
        a2.add(1);
        int i =0;
        int a,b;
        while(i<106 && !a1.isEmpty()&& !a2.isEmpty()){
            a= (int) a1.getFirst();
            b= (int) a2.getFirst();
            a1.removeFirst();
            a2.removeFirst();
            if(a==b) {
                a1.addLast(a);
                a2.addLast(b);
            }
            if(((a>b)&&(a!=9 && b!=0)) || (a==0 && b==9)){
                a1.addLast(a);
                a1.addLast(b);
            }
            else{
                if(a<b ||  (a==9 && b==0)) {
                    a2.addLast(b);
                    a2.addLast(a);
                }
            }
            i++;
        }
        if(a1.isEmpty()){
            System.out.println("second "+i);
        }
        else {
            if(a2.isEmpty()){
                System.out.println("first "+i);
            }
            else {
                System.out.println("botva");
            }
        }
    }
}
