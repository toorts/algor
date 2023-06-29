package hw_2;

import java.io.FileNotFoundException;

public class Task3 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = new int[2];
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Ошибка деления на ноль!");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Индекс массива выходит за пределы допустимого диапазона!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}
