package hust.soict.hedspi.aims.utils;

import java.util.Scanner;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String convertDay(){
        //yy-mm-dd
        String monthStr = new String();
        String dayStr = new String();
        if(this.month<10 && this.month>0){
            monthStr = String.format("0%d",this.month);
        }else{
            monthStr = String.format("%d",this.month);
        }
        if(this.day<10 && this.day >0){
            dayStr = String.format("0%d",this.day);
        }else{
            dayStr = String.format("%d",this.day);
        }
        return this.year+"-"+monthStr+"-"+dayStr;
    }

    public String printDate(){
        String dayStr;
        String monthStr;
        String yearStr;
        switch (this.day){
            case 1:
                dayStr = "1st";
                break;
            case 2:
                dayStr = "2nd";
                break;
            case 3:
                dayStr = "3rd";
                break;
            default:
                dayStr = this.day + "th";
                break;
        }
        String[] monthInYear = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        monthStr = monthInYear[this.month-1];
        yearStr = String.valueOf(this.year);
        return monthStr + " " + dayStr + " " + yearStr;
    }
    public String yourChoice(){
        String output = new String();
        Scanner scanner = new Scanner(System.in);
        System.out.println("List choice: \n" +
                "1: yyyy-MM-dd\n" +
                "2: d/M/yyyy\n" +
                "3: dd-MMM-yyyy\n" +
                "4: MMM-d-yyyy\n" +
                "5: mm-dd-yyyy\n");
        System.out.println("Press: ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                if(this.month<10 && this.month>=1){
                    output =  String.format("%d-0%d-%d",year,month,day);
                }else{
                    output =  String.format("%d-%d-%d",year,month,day);
                }
                System.out.println(output);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                System.out.println("Invalid format");
                break;
        }
        return output;
    }
}
