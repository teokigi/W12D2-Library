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
        assertEquals(3,library.maxCapacity());
    }

    @Test
    public void hasBooks(){
        assertEquals(2,library.bookCount());
    }

    @Test
    public void capacityGateTrue(){
        assertEquals(true,library.capCheck());
    }

    @Test
    public void capacityGateFalse(){
        library.addBook(book3);
        assertEquals(false,library.capCheck());
    }

    @Test
    public void test003addBook(){
        library.addBook(book3);
        assertEquals(3, library.bookCount());
    }

    @Test
    public void test004addBookWhenCapacityLimitReached(){
        library.addBook(book3);
        library.addBook(book3);
        assertEquals(3, library.bookCount());
    }

    @Test
    public void test005genreGateTrue(){
        assertEquals(true,library.genreCheck("science"));
    }

    @Test
    public void test006genreGateFalse(){
        assertEquals(false,library.genreCheck("action"));
    }

    @Test
    public void test007genreCountAddition(){
        library.genrePlus("science");
        assertEquals(2,library.countGenre("science"));
    }

    @Test
    public void test008genreCountSubtraction(){
        library.genreMinus("science");
        assertEquals(0,library.countGenre("science"));
    }

    @Test
    public void test009newGenreCountStart(){
        library.genreNew("action");
        assertEquals(1,library.countGenre("action"));
    }

    @Test
    public void test010bookGenreTracking(){
        library.addBook(book3);
        assertEquals(2, library.countGenre("science"));
    }

    @Test
    public void test011rentABook(){
        library.removeBook(book2);
        assertEquals(1, library.bookCount());
    }


}
