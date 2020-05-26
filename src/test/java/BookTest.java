import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;

    @Before
    public void before(){
        book = new Book("title","author","genre");
    }

    @Test
    public void hasTitle(){
        assertEquals("title",book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("author",book.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals("genre", book.getGenre());
    }
}
