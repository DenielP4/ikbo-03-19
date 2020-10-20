package practice12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int l = s.length();
        char ch = s.charAt(0);
        System.out.print('+');
        if(ch!='+') System.out.println("<7>"+"-<"
                +s.substring(s.substring(1,l-10).length()+1,l-7)
                +">-<"+s.substring(l-7,l-4)
                +">-<"+s.substring(l-4,l)+">");
        else System.out.println("<"+s.substring(1,l-10)+">-<"
                +s.substring(s.substring(1,l-10).length()+1,l-7)
                +">-<"+s.substring(l-7,l-4)
                +">-<"+s.substring(l-4,l)+">");
    }
}
