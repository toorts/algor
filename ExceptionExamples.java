package hw_1;

public class ExceptionExamples {
    // Метод, генерирующий ArithmeticException
    public static void divideByZero() {
        int result = 10 / 0; // Деление на ноль
    }

    // Метод, генерирующий ArrayIndexOutOfBoundsException
    public static void accessArray() {
        int[] arr = {1, 2, 3};
        int element = arr[3]; // Обращение к несуществующему индексу массива
    }

    // Метод, генерирующий NullPointerException
    public static void operateOnNull() {
        String text = null;
        int length = text.length(); // Вызов метода на null ссылке
    }

    public static void main(String[] args) {
        try {
            divideByZero();
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение: " + e);
        }

        try {
            accessArray();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
        }

        try {
            operateOnNull();
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение: " + e);
        }
    }
}
