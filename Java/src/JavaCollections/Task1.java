package JavaCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        int n = 10;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i + 1);
            linkedList.add(i + 1);
        }

        System.out.println("Список: " + arrayList);

        System.out.println("\nArrayList:");
        Long arrayListPerformingTime = getTime(arrayList);

        System.out.println("\n\nLinkedList:");
        Long linkedListPerformingTime = getTime(linkedList);

        if (arrayListPerformingTime - linkedListPerformingTime > 0) {
            System.out.println("\n\nLinkedList быстрее!!!");
        } else {
            System.out.println("\n\nArrayList быстрее!!!");
        }
    }

    private static Long getTime(List list) {
        Long startTime = System.nanoTime();
        ruleOut(list);
        Long finishTime = System.nanoTime();
        System.out.println(list);
        System.out.printf("%,d ns", finishTime - startTime);
        return finishTime - startTime;
    }

    private static void ruleOut(List list) {
        int count = 0;
        Iterator iterator = list.iterator();
        while (list.size() > 1) {
            if (iterator.hasNext()) {
                iterator.next();
                count++;
                if (count == 2) {
                    iterator.remove();
                    count = 0;
                }
            } else {
                iterator = list.iterator();
                System.out.println(list);
            }
        }
    }
}
