package task1;

import java.util.Arrays;
import java.util.List;

/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list);

        System.out.println(list.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum() / list.stream()
                .filter(number -> number % 2 == 0)
                .toList()
                .size());
    }
}
