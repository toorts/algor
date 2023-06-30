package hw_3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserDataApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные через пробел -> Фамилия Имя Отчество ДатаРождения НомерТелефона Пол: ");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.err.println("Ошибка: неверное количество данных.");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDateStr = data[3];
        String phoneNumberStr = data[4];
        String genderStr = data[5];

        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateStr, CustomDateFormatter.getFormatter());
        } catch (DateTimeParseException e) {
            System.err.println("Ошибка: неверный формат даты рождения.");
            return;
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат номера телефона.");
            return;
        }

        Gender gender;
        try {
            gender = Gender.fromString(genderStr);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: неверное значение пола.");
            return;
        }

        String userData = lastName + " " + firstName + " " + middleName + " " +
                birthDateStr + " " + phoneNumberStr + " " + genderStr;

        String fileName = lastName + ".txt";
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(userData + System.lineSeparator());
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }

    private static class CustomDateFormatter {
        private static final String PATTERN = "dd.MM.yyyy";

        private static java.time.format.DateTimeFormatter getFormatter() {
            return java.time.format.DateTimeFormatter.ofPattern(PATTERN);
        }
    }

    private enum Gender {
        MALE("m"),
        FEMALE("f");

        private final String value;

        Gender(String value) {
            this.value = value;
        }

        public static Gender fromString(String value) {
            for (Gender gender : values()) {
                if (gender.value.equalsIgnoreCase(value)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException("Invalid gender value: " + value);
        }
    }
}
