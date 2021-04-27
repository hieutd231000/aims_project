package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }
    public Book(String title, String category, float cost){
        super(title,category,cost);
    }
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public boolean addAuthor(String authorName){
        if(authorIs(authorName) == null){
            authors.add(authorName);
            return true;
        }
        return false;
    }

    public boolean removeAuthor(String authorName){
        if(authorIs(authorName) == null){
            return false;
        }
        authors.remove(authorName);
        return true;
    }

    private String authorIs(String authorName){
        for(int i=0; i< authors.size(); i++){
            if(authors.get(i).equals(authorName)){
                return authors.get(i);
            }
        }
        return null;
    }
    public String toString() {
        return  super.getTitle() +
                "-" + super.getCategory() +
                ":" + super.getCost() + "$";
    }
}
