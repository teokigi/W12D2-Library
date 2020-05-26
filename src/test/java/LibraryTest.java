import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    Book book1;
    Book book2;
    Book book3;

    @Before
    public void before(){
        book1 = new Book("title","author","genre");
        book2 = new Book("Applied Physics","Mr fizizist","science");
        book3 = new Book("Psychology", "Mr Peterson", "science");
        library = new Library(3);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void hasCapacity(){
        assertEquals(5,library.maxCapacity());
    }

    @Test
    public void hasBooks(){
        assertEquals(2,library.bookCount());
    }

    @Test
    public void addBook(){
        library.addBook(book3);
        assertEquals(3, library.bookCount());
    }

    @Test
    public void addBookWhenCapacityLimitReached(){
        library.addBook(book3);
        library.addBook(book3);
        assertEquals(3, library.bookCount());
    }

    @Test
    public void bookGenreTracking(){
        library.addBook(book3);
        assertEquals(2, library.countGenre("science"));
    }

    @Test
    public void genreGateTrue(){
        assertEquals(true,library.genreCheck("science"));
    }

    @Test
    public void genreGateFalse(){
        assertEquals(false,library.genreCheck("action"));
    }

    @Test
    public void genreCountAddition(){
        library.genrePlus("science");
        assertEquals(2,library.countGenre("science"));
    }

    @Test
    public void genreCountSubtraction(){
        library.genreMinus("science");
        assertEquals(0,library.countGenre("science"));
    }

    @Test
    public void rentABook(){
        library.removeBook(book2);
        assertEquals(2, library.bookCount());
    }


}
