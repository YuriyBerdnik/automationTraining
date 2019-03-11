package JavaClasses;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BooksInfo {
    public static void main(String[] args) {
        BookAr bookAr = new BookAr();
        Book b1 = new Book("Onegin", "Pushkin", 1989, 77, "RUS", 88.77);
        Book b2 = new Book("Poetry", "Kipling", 2005, 555, "ENG", 22.77);
        Book b3 = new Book("The Jungle Book", "Kipling", 1989, 345, "RUS", 777);
        Book b4 = new Book("Onegin", "Esenin", 1988, 88, "RUS", 767);
        Book b5 = new Book("Heroi nashego vremeni", "Lermontov", 1989, 77,
                "RUS", 88.99);
        bookAr.add(b1);
        bookAr.add(b2);
        bookAr.add(b3);
        bookAr.add(b4);
        bookAr.add(b5);

        System.out.println("Find by Title:");
        System.out.println();

        System.out.println("Result1:");
        bookAr.Result1("Onegin");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");

        System.out.println("Find by Lang:");
        bookAr.findByLang("RUS");
        System.out.println(" ");

        System.out.println("Result2:");
        bookAr.Result2("RUS");
        System.out.println("");

        bookAr.delete(b5);
        bookAr.findByTitle("Heroi nashego vremeni");
        System.out.println("");
    }

    public static Set<Book> findByTitle(List<Book> book1, String author) {
        Set<Book> sortedBooks = new TreeSet<Book>(new CompareBy());

        for (Book book : book1) {

            if (book.getAuthor().equals(author)) {
                sortedBooks.add(book);

            }
        }
        return sortedBooks;
    }
}
