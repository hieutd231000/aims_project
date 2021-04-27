package hust.soict.hedspi.aims.media;

public abstract class Disc extends Media{
    private String director;
    private int length;
    public Disc(String title, String category,float cost, String director, int length) {
        super(title,category,cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(){}

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
