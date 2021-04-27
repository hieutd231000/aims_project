package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.MyDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Order anOrder;

    public static Media createMediaItemFromConsole(AbstractItemFactory factory){
        return factory.createItemFromConsole();
    }
    public static void showCreationMenu(){
        System.out.println("1: Create Book");
        System.out.println("2: Create CD");
        System.out.println("3: Create DVD");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
            case 2:
                createMediaItemFromConsole(new CDFactory());
                break;

        }
    }

    public static void main(String[] args) {
        showCreationMenu();
        boolean quit = false;
        showMenu();
        while (!quit){
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    makeOrder();
                    System.out.println("Make order succeed");
                    break;
                case 2:
                    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",19.95f,"Roger Allers",87);
                    anOrder.addMedia(dvd1);

                    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War","Science Fiction",24.95f,"Geogre Lucas",124);
                    anOrder.addMedia(dvd2);

                    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation",18.95f,"John Musker",90);
                    anOrder.addMedia(dvd3);

                    Book b1 = new Book("The happiness","Science",15.95f);
                    b1.addAuthor("James");
                    anOrder.addMedia(b1);

                    CompactDisc c1 = new CompactDisc("Hieu","Aladdin","Animation",18.95f,"John Musker",80);
                    anOrder.addMedia(c1);
                    showItem();
                    break;
                case 3:
                    System.out.println("Press id you want delete: ");
                    int delete = scanner.nextInt();
                    anOrder.getItemsOrdered().remove(delete-1);
                    showItem();
                    break;
                case 4:
                    showItem();
                    break;
            }
        }
/*
        MyDate mydate = new MyDate(23,3,2000);
        Order anOrder = new Order(mydate);
        if(Order.checkLimitOrder()){

            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
            anOrder.addDigitalVideoDisc(dvd1);

            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War","Science Fiction","Geogre Lucas",124,24.95f);
            anOrder.addDigitalVideoDisc(dvd2);

            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin","Animation","John Musker",90,18.99f);
            anOrder.addDigitalVideoDisc(dvd3);

            anOrder.removeDigitaVideoDisc(dvd3);

            DigitalVideoDisc myDvd[] = new DigitalVideoDisc[2];
            myDvd[0] = new DigitalVideoDisc("The King","Animation","Roger Allers",87,9.95f);
            myDvd[1] = new DigitalVideoDisc("The Fast King","Animation","Roger Allers",87,29.95f);
            anOrder.addDigitalVideoDisc(myDvd);

            DigitalVideoDisc dvd4 = new DigitalVideoDisc("My Song","Science Fiction","Geogre Lucas",124,24.95f);
            DigitalVideoDisc dvd5 = new DigitalVideoDisc("Her Song","Science Fiction","Geogre Lucas",124,24.95f);
            anOrder.addDigitalVideoDisc(dvd4,dvd5);
            anOrder.removeDigitaVideoDisc(dvd4);
            //get lucky item
            anOrder.getLuckyItem();
            anOrder.viewOrder();
        }
        //search item
        System.out.println("\nSearch item: ");
        String itemSearch = scanner.nextLine();
        int size = anOrder.qtyOrdered();
        for(int i=0; i<size; i++){
            if(anOrder.getItemOrdered()[i].search(itemSearch)){
                System.out.println(anOrder.getItemOrdered()[i].toString());
            }
        }
        //DateTest.main(args);*/
    }
    public static void showMenu() {
        System.out.println("\nOrder Management Application: ");
        System.out.println("--------------------------------");
        System.out.println("1. Create new order");
        System.out.println("2. Add item to the order");
        System.out.println("3. Delete item by id");
        System.out.println("4. Display the items list of order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        System.out.println("Press: ");
    }
    public static void makeOrder(){
        String curDay = java.time.LocalDate.now().toString();
        String[] strDay = curDay.split("-");
        int day = Integer.parseInt(strDay[2]);
        int month = Integer.parseInt(strDay[1]);
        int year = Integer.parseInt(strDay[0]);
        MyDate myDate = new MyDate(day,month,year);
        anOrder = new Order(myDate);
    }
    public static void showItem(){
        anOrder.viewOrder();
    }
}
