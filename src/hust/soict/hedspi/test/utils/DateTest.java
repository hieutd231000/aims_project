package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DateTest {
    public static void main(String[] args){
        MyDate myDate1 = new MyDate(13,8,1999);
        MyDate myDate2 = new MyDate(24,2,1999);
        MyDate myDate3 = new MyDate(4,2,1998);
        MyDate myDate4 = new MyDate(31,12,2000);
        MyDate myDate5 = new MyDate(1,12,2000);
        MyDate arr[] = new MyDate[5];
        arr[0] = myDate1;
        arr[1] = myDate2;
        arr[2] = myDate3;
        arr[3] = myDate4;
        arr[4] = myDate4;
        DateUtils.sortDate(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i].convertDay());
        }
    }
}
