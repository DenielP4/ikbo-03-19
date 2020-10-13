package practice9;

import java.util.Scanner;

public class LabClassUI {
    public static void main(String[] args) {
        final int length = 3;
        Scanner in = new Scanner(System.in);
        Student[] math = new Student[length];
        System.out.println("Введите фамилию и оценку "+length+" студентов");
        for (int i = 0; i < length; i++)
        {
            String name = in.next();
            int mark = in.nextInt();
            math[i] = new Student( name, mark);
        }
        LabClass labClass = new LabClass(math);
        labClass.quickSort( 0, length - 1);
        System.out.println("Введите фамилию студента, наличие которого хотите проверить");
        try
        {
            System.out.println(labClass.findStudent(in.next()));
        }
        catch(StudentNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
