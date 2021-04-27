package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;

public class Order {

    public static final int MAX_NUMBERS_ORDERED = 10;
    //private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private int count = 0;

    private MyDate dateOrdered;
    public static final int MAX_LIMITED_ORDERS = 3;
    public static int nOrders = 0;

    public static boolean checkLimitOrder(){
        return nOrders<MAX_LIMITED_ORDERS;
    }
    public Order(MyDate today){
        nOrders ++;
        this.dateOrdered = today;
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public boolean addMedia(Media media){
        if(findMedia(media)==null){
            itemsOrdered.add(media);
            return true;
        }
        return false;
    }
    public boolean removeMedia(Media media){
        Media curMedia= findMedia(media);
        if(curMedia==null){
            return false;
        }
        itemsOrdered.remove(curMedia);
        return true;
    }
    public int qtyOrdered(){
        return itemsOrdered.size();
    }
    public Media findMedia(Media media){
        for(Media checkMedia: this.itemsOrdered){
            if(checkMedia.getTitle().equals(media.getTitle())){
                return checkMedia;
            }
        }
        return null;
    }

    public float totalCost(){
        float f = 0;
        for(int i=0; i<qtyOrdered(); i++){
            f += itemsOrdered.get(i).getCost();
        }
        return f;
    }
    public void viewOrder(){
        if(itemsOrdered.isEmpty()){
            System.out.println("List empty");
        }else{
            System.out.println("*******************Order*********************");
            System.out.println("Date: " + dateOrdered.printDate());
            for(int i=0 ; i<qtyOrdered(); i++){
                System.out.println(i+1 + ": " + itemsOrdered.get(i).toString());
            }
            System.out.println("Total cost: " + totalCost());
            System.out.println("*********************************************");
        }
    }

    public Media getLuckyItem() {
        double randomDouble = Math.random()* 1000;
        int randomInt = (int) randomDouble % (qtyOrdered());
        Media luckyItem = itemsOrdered.get(randomInt);
        System.out.println("\nYour lucky item: " + luckyItem.toString() + "\n");
        luckyItem.setCost(0f);
        return luckyItem;
    }




/*
    public DigitalVideoDisc[] getItemOrdered() {
        return itemOrdered;
    }
    public boolean addDigitalVideoDisc(DigitalVideoDisc disc){
        if(count>=MAX_NUMBERS_ORDERED){
            System.out.println("The order is almost full");
            return false;
        }
        itemOrdered[count] = disc;
        count++;
        return true;
    }
    public boolean addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        if(dvdList.length > MAX_NUMBERS_ORDERED - qtyOrdered()){
            System.arraycopy(dvdList,0,itemOrdered,qtyOrdered(),MAX_NUMBERS_ORDERED-qtyOrdered());
            System.out.println("List DVD not add: ");
            for(int i=MAX_NUMBERS_ORDERED-qtyOrdered(); i<dvdList.length; i++){
                System.out.println(dvdList[i].getTitle());
            }
            this.count = MAX_NUMBERS_ORDERED;
            return false;
        }
        System.arraycopy(dvdList,0,itemOrdered,qtyOrdered(),dvdList.length);
        this.count += dvdList.length;
        return true;
    }
    public boolean addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if(qtyOrdered()<=MAX_NUMBERS_ORDERED-2){
            this.itemOrdered[count] = dvd1;
            count++;
            this.itemOrdered[count] = dvd2;
            count++;
            return true;
        }
        else if(qtyOrdered()<=MAX_NUMBERS_ORDERED-1){
            this.itemOrdered[count] = dvd1;
            count++;
            System.out.println("DVD cannot add: " + dvd2.getTitle());
            return false;
        }else{
            System.out.println("List DVD cannot add: \n" + dvd1.getTitle() + "\n" + dvd2.getTitle());
            return false;
        }
    }

    public int qtyOrdered(){
        return this.count;
    }
    public boolean removeDigitaVideoDisc(DigitalVideoDisc disc){
        for(int i=0; i<qtyOrdered(); i++){
            if(itemOrdered[i].getTitle().equalsIgnoreCase(disc.getTitle())){
                System.arraycopy(itemOrdered,i+1,itemOrdered,i,qtyOrdered()-i-1);
                count--;
                return true;
            }
        }
        return false;
    }
    public float totalCost(){
        float f = 0;
        for(int i=0; i<qtyOrdered(); i++){
            f += itemOrdered[i].getCost();
        }
        return f;
    }
    public void viewOrder(){
        if(qtyOrdered()==0){
            System.out.println("List empty");
        }else{
            System.out.println("*******************Order*********************");
            System.out.println("Date: " + dateOrdered.printDate());
            for(int i=0 ; i<qtyOrdered(); i++){
                System.out.println(i+1 + ".DVD: " + itemOrdered[i].toString());
            }
            System.out.println("Total cost: " + totalCost());
            System.out.println("*********************************************");
        }
    }

    public DigitalVideoDisc getLuckyItem() {
        double randomDouble = Math.random()* 1000;
        int randomInt = (int) randomDouble % qtyOrdered();
        DigitalVideoDisc luckyItem = itemOrdered[randomInt];
        System.out.println("\nYour lucky item: " + luckyItem.toString() + "\n");
        luckyItem.setCost(0f);
        return luckyItem;
    }
*/
}

