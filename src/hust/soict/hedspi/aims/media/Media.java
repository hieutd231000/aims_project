package hust.soict.hedspi.aims.media;

public abstract class Media {
    private String title;
    private String category;
    private float cost;

    public String getTitle() {
        return title;
    }

    public String getCategory(){
        return category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(){}
}
