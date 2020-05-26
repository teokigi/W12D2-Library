import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> collection;
    private HashMap<String,Integer> genres;
    private int bookCapacity;

    public Library(int capacity){
        this.collection = new ArrayList<>();
        this.genres = new HashMap<>();
        this.bookCapacity = capacity;
    }

    public void addBook(Book book){
        this.collection.add(book);
        if (genreCheck(book.getGenre())){
            genrePlus(book.getGenre());
        } else{
            genreNew(book.getGenre());
        }
    }

    public int maxCapacity(){
        return this.bookCapacity;
    }

    public int bookCount(){
        return this.collection.size();
    }

    public boolean genreCheck(String genre){
        return this.genres.containsValue(genre);
    }

    public void genrePlus(String genre){
        //this.genres.put(genre, this.genres.get(genre) + 1)
        Integer temp = this.genres.get(genre);
        temp++;
        this.genres.put(genre, temp);
    }

    public void genreMinus(String genre){
        //this.genres.put(genre, this.genres.get(genre) - 1)
        Integer temp = this.genres.get(genre);
        temp--;
        this.genres.put(genre,temp);
    }

    public void genreNew(String genre){
        this.genres.put(genre, 1);
    }

    public int countGenre(String genre){
        if (genreCheck(genre)){
            return this.genres.get(genre);
        } else{
            return 0;
        }
    }

    public void removeBook(Book book){
        this.collection.remove(book);
        genreMinus(book.getGenre());
    }
}
