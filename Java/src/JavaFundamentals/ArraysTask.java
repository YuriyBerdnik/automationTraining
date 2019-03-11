package JavaFundamentals;

//Ввести с консоли n-размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -n до n с помощью генератора случайных чисел.
//1.Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
//2.Выполнить циклический сдвиг заданной матрицы на k позиций вправо (влево, вверх, вниз).
//3.Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
//4.Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
//5.Перестроить матрицу, переставляя в ней строки так, чтобы сумма элементов в строках полученной матрицы возрастала.
//6.Найти максимальный элемент (ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие

import java.util.Scanner;

public class ArraysTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ввести с консоли n-размерность матрицы: ");
        int n = scanner.nextInt();
        int[][] mas = new int[n][n];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = ((int) (Math.random() * (n * 2 + 1)) - n);
                System.out.print(mas[i][j] + " ");
            }
        }

        System.out.println("\n\n" + "Сумма элементов матрицы, расположенных между первым и вторым положительными элементами: ");
        int indexStart = 0;
        int indexEnd = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (i > 0) {
                    indexStart = i;
                    break;
                }
                for (int k = indexStart + 1; k < mas.length; k++) {
                    if (k > 0) {
                        indexEnd = k;
                        break;
                    }
                }
                int sum = 0;
                for (int l = mas[i + 1][j]; l < indexEnd; l++) {
                    sum += l;
                    System.out.print(sum + " ");
                }
            }
        }
    }
}
