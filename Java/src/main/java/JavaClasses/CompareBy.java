package JavaClasses;

import java.util.Comparator;

public class CompareBy implements Comparator<Book> {
    public int compare(Book first, Book second) {
        double firstPrice = first.getPrice();
        double secondPrice = second.getPrice();

        int firstYear = first.getYear();
        int secondYear = second.getYear();

        if (firstPrice < secondPrice) {
            return -1;

        } else if (firstPrice > secondPrice) {
            return 1;
        } else {

            if (firstYear < secondYear) {
                return -1;
            } else if (firstYear > secondYear) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
