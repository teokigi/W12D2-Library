import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private final ArrayList<Book> collection;
    private final HashMap<String,Integer> genres;
    private final int bookCapacity;

    public Library(int capacity){
        this.collection = new ArrayList<>();
        this.genres = new HashMap<>();
        this.bookCapacity = capacity;
    }

    public void addBook(Book book){
        if (capCheck()) {
            this.collection.add(book);
            genrePlus(book.getGenre());
        }
    }

    public int maxCapacity(){
        return this.bookCapacity;
    }

    public boolean capCheck(){
        return bookCount() < maxCapacity();
    }

    public int bookCount(){
        return this.collection.size();
    }

    public boolean genreCheck(String genre){
        return this.genres.containsKey(genre);
    }

    public void genrePlus(String genre){
        if (genreCheck(genre)){
            this.genres.put(genre, this.genres.get(genre) + 1);
        } else{
            genreNew(genre);
        }

    }

    public void genreMinus(String genre){
        if(genreCount(genre) <= 1) {
            this.genres.put(genre,0);
        }else {
            this.genres.put(genre, this.genres.get(genre) - 1);
        }
    }

    public void genreNew(String genre){
        this.genres.put(genre, 1);
    }


    public int genreCount(String genre){
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
