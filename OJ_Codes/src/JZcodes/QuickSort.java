package JZcodes;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] data,int start,int end){
        if(data==null||data.length==1)
            return;
        int index = Partration.partration(data,start,end);
        System.out.println("after partrition "+index+" "+Arrays.toString(data));
        if(index>start){
            sort(data,start,index);
        }
        if(index<end){
            sort(data,index+1,end);
        }
    }

    public static void main(String[] args) {
        int[] data = {9};
        sort(data,0,data.length);
        System.out.println(Arrays.toString(data));

    }
}
