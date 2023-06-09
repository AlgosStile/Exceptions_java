package hw_3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * Формат ввода данных для проверки следующий:
 * Фамилия Имя Отчество 09.06.2023 89653748587 f
 * или так:
 * Фамилия Имя Отчество 09.06.2023 89643748587 m
 */
public class UserDataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        try {
            writeUserDataToFile(data);
            System.out.println("Данные успешно записаны в файл.");
        } catch (IllegalArgumentException | IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void writeUserDataToFile(String[] data) throws IllegalArgumentException, IOException {
        if (data.length != 6) {
            throw new IllegalArgumentException("Неверное количество параметров.");
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDateStr = data[3];
        String phoneNumberStr = data[4];
        String genderStr = data[5];

        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты рождения.", e);
        }

        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона.", e);
        }

        Gender gender = Gender.fromCode(genderStr);
        if (gender == null) {
            throw new IllegalArgumentException("Неверный формат пола.");
        }

        String fileName = lastName + ".txt";
        FileWriter fileWriter;

        try {
            fileWriter = new FileWriter(fileName, true);
        } catch (IOException e) {
            throw new IOException("Ошибка при открытии файла.", e);
        }

        try {
            fileWriter.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender.getCode() + "\n");
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            throw new IOException("Ошибка при записи данных в файл.", e);
        } finally {
            fileWriter.close();
        }
    }
}

enum Gender {
    MALE('m'),
    FEMALE('f');

    private final char code;

    Gender(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static Gender fromCode(String codeStr) {
        if (codeStr == null || codeStr.isEmpty()) {
            return null;
        }

        char code = codeStr.charAt(0);

        for (Gender gender : values()) {
            if (gender.getCode() == code) {
                return gender;
            }
        }

        return null;
    }
}
