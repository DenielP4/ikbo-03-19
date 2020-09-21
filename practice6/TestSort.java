package practice6;

import java.util.Arrays;
import java.util.Scanner;

public class TestSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of students: ");
        Student[] students = new Student[scanner.nextInt()];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student((int) Math.round(Math.random() * 1000), i + " student");
        }
        System.out.println("Initial array of students:");
        Arrays.stream(students).forEach(System.out::println);

        System.out.println("\nSorted array:");
        insertionSort(students);
        Arrays.stream(students).forEach(System.out::println);
    }

    private static void insertionSort(Student[] array) {
        for (int i = 1; i < array.length; i++) {
            Student currStudent = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].getId() > currStudent.getId()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currStudent;
        }
    }
}