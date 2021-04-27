package hust.soict.hedspi.aims.media;

import java.util.Scanner;

public class CDFactory implements AbstractItemFactory{
    @Override
    public Media createItemFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input title: ");
        CompactDisc cd = new CompactDisc();
        String title = sc.nextLine();
        cd.setTitle(title);
        String category = sc.nextLine();
        cd.setCategory(category);
        float cost = sc.nextFloat();
        sc.nextLine();
        cd.setCost(cost);
        return cd;
    }
}
