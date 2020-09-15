package lab8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        try(FileWriter writer = new FileWriter("text_lab8.txt", false)){
            String text = new String(in.next());
            writer.append(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
