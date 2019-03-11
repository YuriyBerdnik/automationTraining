package JavaClasses;

import java.util.ArrayList;
import java.util.List;

public class BookAr {
    private Book book;

    List<Book> booksList = new ArrayList<Book>();

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public void add(Book book) {
        booksList.add(book);
    }

    public boolean delete(Book book) {
        return booksList.remove(book);
    }

    public void findByTitle(String title) {
        for (Book book : booksList) {
            if (book.getTitle().equals(title)) {
                System.out.println(book);
            }
        }
    }

    public void findByLang(String lang) {
        for (Book book : booksList) {
            if (book.getTitle().equals(lang)) {
                System.out.println(book);
            }
        }
    }

    public void Result1(String title) {
        for (Book book : booksList) {
            if (book.getTitle().equals(title)) {
                System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|" + book.getTitle() + "   |     " + book.getAuthor() + "   |      " + book.getYear() + "|     " + book.getPages() + "   |     " + book.getLang() + "   |     " + book.getPrice());
            }
        }
    }

    public void Result2(String lang) {
        for (Book book : booksList) {
            if (book.getLang().equals(lang)) {
                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("|" + book.getTitle() + "   |     " + book.getAuthor() + "   |      " + book.getYear() + "   |     " + book.getPages() + "   |     " + book.getLang() + "   |     " + book.getPrice());
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }
}
