package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void play(){
        for(int i=0; i<tracks.size(); i++){
            tracks.get(i).play();
        }
    }
    public CompactDisc(String artist,String title, String category,float cost, String director, int length ){
        super(title,category,cost,director,length);
        this.artist = artist;
    }
    public CompactDisc(){}

    public boolean addTrack(String title){
        if(trackIs(title)==null){
            tracks.add(new Track(title));
            return true;
        }
        return false;
    }
    public boolean removeTrack(String title){
        Track track_rem = trackIs(title);
        if(track_rem!=null){
            tracks.remove(track_rem);
            return true;
        }
        return false;
    }
    public int getLength(){
        int sum = 0;
        for(int i=0; i< tracks.size(); i++){
            sum += tracks.get(i).getLength();
        }
        return sum;
    }
    private Track trackIs(String title){
        for(int i=0; i< tracks.size(); i++){
            if(tracks.get(i).getTitle().equals(title)){
                return tracks.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CompactDisc{" +
                "artist='" + artist + '\'' +
                ", tracks=" + tracks +
                '}';
    }
}
