package hust.soict.hedspi.aims.utils;

public class DateUtils {
    public static int compareDate(MyDate date1, MyDate date2){
        return date1.convertDay().compareTo(date2.convertDay());
    }
    public static MyDate[] sortDate(MyDate[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(compareDate(arr[i],arr[j])>0){
                    MyDate saveD = arr[i];
                    arr[i] = arr[j];
                    arr[j] = saveD;
                }
            }
        }
        return arr;
    }
}
