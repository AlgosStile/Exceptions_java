package org.example;

import java.util.Scanner;

public class Ex_homework_2 {
    // Вот реализация метода для запроса дробного числа:
    public static float getFloatInput(Scanner scanner) {
        System.out.print("Введите дробное число: ");
        while (!scanner.hasNextFloat()) {
            System.out.println("Вы ввели неверный формат числа. Попробуйте еще раз.");
            scanner.nextLine(); // читаем лишний символ перевода строки
        }
        return scanner.nextFloat();
    }

    // Для задания 2, нужно убедиться, что переменная num инициализируется перед использованием, например:
    int num = 0;
do

    {
        System.out.println("Введите положительное число: ");
        try {
            num = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный формат числа!");
        }
    } while(num <=0);
System.out.println("Вы ввели число "+num);


   // Для задания 3, необходимо добавить оператор break после каждой кейс-ветки в блоке switch:
            switch (dayOfWeek) {
        case 1:
            System.out.println("Понедельник");
            break;
        case 2:
            System.out.println("Вторник");
            break;
        case 3:
            System.out.println("Среда");
            break;
        case 4:
            System.out.println("Четверг");
            break;
        case 5:
            System.out.println("Пятница");
            break;
        case 6:
            System.out.println("Суббота");
            break;
        case 7:
            System.out.println("Воскресенье");
            break;
        default:
            System.out.println("Такого дня недели не существует");
            break;
    }

    //Наконец, для задания с исключением, можно реализовать следующий метод:
    public static String getNonEmptyStringInput(Scanner scanner) throws Exception {
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new Exception("Строка не может быть пустой!");
        }
        return input;
    }
    //Этот метод (код выше) запрашивает у пользователя ввод строки и выбрасывает исключение, если строка пустая.
    // Если строка не пустая, метод возвращает ее значение.
}
