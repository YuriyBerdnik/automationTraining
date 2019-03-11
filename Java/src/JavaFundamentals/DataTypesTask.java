package JavaFundamentals;

//Ввести n чисел с консоли.
//1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
//2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
//3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
//4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько, найти первое из них.
//5. Найти количество чисел, содержащих только четные цифры, а среди
// них — количество чисел с равным числом четных и нечетных цифр.
//6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
//7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
//8. Среди чисел найти число-палиндром. Если таких чисел больше одного, найти второе.

import java.util.Scanner;

public class DataTypesTask {
    public static void main(String[] args) {
        System.out.println("Enter 10 numbers: ");
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int min = numbers[0];
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) min = numbers[i];
            if (numbers[i] > max) max = numbers[i];
        }
        System.out.print("\n" + "Min number: " + min + "; Max number: " + max + "\n");

        int sum = 0;
        for (int element : numbers) {
            sum += element;
        }
        System.out.println("\n" + "Числа, длина которых меньше средней: ");
        for (int element : numbers) {
            if (element < sum / numbers.length)
                System.out.println(element + " ");
        }
    }
}
