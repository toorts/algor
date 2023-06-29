package hw_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        float number = getFloatInput();
        System.out.println("Введенное число: " + number);
    }

    public static float getFloatInput() {
        float input = 0.0f;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            System.out.print("Введите дробное число: ");

            try {
                input = scanner.nextFloat();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введено некорректное значение. Попробуйте снова.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }

        return input;
    }
}
