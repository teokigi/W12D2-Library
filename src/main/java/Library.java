import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> collection;
    private HashMap<String,Integer> genres;
    private int bookCapacity;

    public Library(int capacity){
        this.collection = new ArrayList<>();
        this.genres = new HashMap();
        this.bookCapacity = capacity;
    }

    public void addBook(Book book){
        this.collection.add(book);
    }

    public int maxCapacity(){
        return this.bookCapacity;
    }

    public int bookCount(){
        return this.collection.size();
    }

    public int countGenre(String genre){
        if (this.genres.containsValue(genre)){
            return this.genres.get(genre);
        } else{
            return 0;
        }
    }
}
