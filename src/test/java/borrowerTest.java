import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class borrowerTest {

    Library library;
    Book book1;
    Book book2;
    Book book3;
    Borrower libraryMember;

    @Before
    public void before(){
        book1 = new Book("title","author","genre");
        book2 = new Book("Applied Physics","Mr Fizzy","science");
        book3 = new Book("Psychology", "Mr Peterson", "science");
        library = new Library(3);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        libraryMember = new Borrower("Tony");
    }

    @Test
    public void hasName(){
        assertEquals("Tony", libraryMember.getName());
    }

    @Test
    public void emptyInitialrentalListing(){
        assertEquals(0,libraryMember.rentalListingCount());
    }

    @Test
    public void borrowABook(){
        libraryMember.borrow(book1,library);
        assertEquals(1,libraryMember.rentalListingCount());
    }

    @Test
    public void handInABook(){
        libraryMember.borrow(book1,library);
        libraryMember.handIn(book1,library);
        assertEquals(0,libraryMember.rentalListingCount());
    }
}
