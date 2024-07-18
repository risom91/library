
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import com.management.domain.Book;
import com.management.libraryManagement.Library;


public class LibraryTest {
    private Library library ;

    @Before
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Title1", "Author1", "123456789", "Fiction", 2020, Arrays.asList("Dept1","Dept2"), true);
        library.addBook(book);
        assertEquals(1, library.listAllBooks().size());
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("Title1", "Author1", "123456789", "Fiction", 2020, Arrays.asList("Dept1","Dept3"), true);
        library.addBook(book);
        library.removeBook("123456789");
        assertEquals(0, library.listAllBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        Book book1 = new Book("Title1", "Author1", "123456789", "Fiction", 2020, Arrays.asList("Dept1"), true);
        Book book2 = new Book("Title2", "Author2", "1234567891", "Non-Fiction", 2021, Arrays.asList("Dept2","Dept3"), true);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.findBooksByTitle("Title1");
        assertEquals(1, books.size());
        assertEquals("123456789", books.get(0).getISBN());
    }

    @Test
    public void testFindBookByAuthor() {
        Book book1 = new Book("Title1", "Author1", "123456789", "Fiction", 2020, Arrays.asList("Dept1"), true);
        Book book2 = new Book("Title2", "Author1", "987654321", "Non-Fiction", 2021, Arrays.asList("Dept2"), true);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.findBooksByAuthor("Author1");
        assertEquals(2, books.size());
    }

    @Test
    public void testListAllBooks() {
        Book book1 = new Book("Title1", "Author1", "123456789", "Fiction", 2020, Arrays.asList("Dept1"), true);
        Book book2 = new Book("Title2", "Author2", "987654321", "Non-Fiction", 2021, Arrays.asList("Dept2"), true);
        Book book3 = new Book("Title2", "Author2", "987654321", "Non-Fiction", 2021, Arrays.asList("Dept2"), true);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        List<Book> books = library.listAllBooks();
        assertEquals(2, books.size());
    }

    @Test
    public void testListAvailableBooks() {
        Book book1 = new Book("Title1", "Author1", "123456789", "Fiction", 2020, Arrays.asList("Dept1"), true);
        Book book2 = new Book("Title2", "Author2", "987654321", "Non-Fiction", 2021, Arrays.asList("Dept2"), false);
        library.addBook(book1);
        library.addBook(book2);
        List<Book> books = library.listAllAvailableBooks();
        assertEquals(1, books.size());
        assertEquals("123456789", books.get(0).getISBN());
    }
}
