package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    public DigitalVideoDisc(String title, String category,float cost, String director, int length ) {
        super(title,category,cost,director,length);
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
    @Override
    public String toString() {

        return  super.getTitle() +
                "-" + super.getCategory() +
                "-" + super.getDirector() +
                "-" + super.getLength() +
                ":" + super.getCost() + "$";
    }

    public boolean search(String title){
        if(title == null){
            return false;
        }
        String[] titleArr = super.getTitle().split(" ");
        for(int i=0; i< titleArr.length; i++){
            if(title.equalsIgnoreCase(titleArr[i])){
                return true;
            }
        }
        return false;
    }
}

