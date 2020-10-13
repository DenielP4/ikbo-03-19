package lab9;

import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner( System.in );
        System.out.print( "Enter an integer ");
        String intString = myScanner.next();
        try {

            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        }
        catch (ArithmeticException e) {
            System.out.println("Деление на 0");
        } catch (Exception e) {
            System.out.println("Не целое");
        }
        finally {
            System.out.println("Все равно");
        }
    }
}
