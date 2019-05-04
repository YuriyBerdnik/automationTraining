package JavaFundamentals;

//Язык Java изучать последовательно практически невозможно. То же самое касается и решения задач. Поэтому при решении задач часто придется использовать знания, которые будут вам даны несколько позже.
//Иначе пришлось бы все задания группировать в конце курса.
//Научиться программировать можно только одним способом - программировать.
//Для успешного обучения из каждого набора заданий достаточно выполнить 1-2.
//1. Приветствовать любого пользователя при вводе его имени через командную строку.
//2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
//3. Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
//4. Ввести целые числа как аргументы командной строки, подсчитать их суммы (произведения) и вывести результат на консоль.

import java.util.Scanner;

public class GettingStartedTask {
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        Scanner scannerName = new Scanner(System.in);
        String name = scannerName.next();
        System.out.println("Hello " + name);

        Scanner scannerArg = new Scanner(System.in);
        System.out.print("\nEnter number: ");
        int value = scannerArg.nextInt();
        int mirror = 0;
        while (value != 0) {
            mirror = mirror * 10 + (value % 10);
            value = value / 10;
        }
        System.out.println("Reverse: " + mirror + "\n");

        int[] numbers = {1, 5, 9, 7, 5, 3};
        for (int i : numbers) {
            System.out.println(i);
        }
        for (int j : numbers) {
            System.out.print(j);
        }
    }
}
