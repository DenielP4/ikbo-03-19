package Lab12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите пароль: ");
        Scanner s = new Scanner(System.in);
        Pattern p = Pattern.compile("^(?=.*[0-9_])(?=.*[A-Z])(?=.*[a-z]).{8,}$");
        Matcher m = p.matcher(s.nextLine());
        boolean res=m.matches();
        if (res) System.out.print("Надёжный пароль");
        else System.out.print("Ненадёжный пароль");
    }
}