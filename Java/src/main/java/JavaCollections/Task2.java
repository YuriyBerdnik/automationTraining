package JavaCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        int y = 10;
        List<Integer> list = new ArrayList<>();

        filling(list, 20);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > y) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j) <= y) {
                        Collections.swap(list, j, i);
                    }
                }
            }
        }
        System.out.println(list);
    }

    private static void filling(List<Integer> list, int number) {
        for (int i = 0; i < number; i++) {
            list.add((int) (Math.random() * number));
        }
    }
}
