import java.util.ArrayList;

public class Borrower {

    private String name;
    private ArrayList<Book> rentalListing;

    public Borrower(String name){
        this.name = name;
        this.rentalListing = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int rentalListingCount(){
        return this.rentalListing.size();
    }

    public void borrow(Book book, Library library){
        library.removeBook(book);
        this.rentalListing.add(book);

    }

    public void handIn(Book book,Library library){
        this.rentalListing.remove(book);
        library.addBook(book);
    }
}
