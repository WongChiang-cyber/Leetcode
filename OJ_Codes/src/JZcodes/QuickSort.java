package JZcodes;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void sort(int[] data,int start,int end){
        if(data==null||data.length==1)
            return;
        int index = partration(data,start,end);
        System.out.println("after partrition "+index+" "+Arrays.toString(data));
        if(index>start){
            sort(data,start,index);
        }
        if(index<end){
            sort(data,index+1,end);
        }
    }

    public int partration(int[] data,int start,int end){
        if(data.length==1)
            return 0;
        if(start>=end)
            return start;
        Random r = new Random();
        int random = r.nextInt(end-start)+start;
        //int random = (start+end)/2;
        //System.out.println(random);
        //put the pivot on the first place
        swap(data,random,start);
        int pivot = data[start];
        //exchange stage
        int first = start;
        int second = start+1;
        while(second<end){
            if(data[second]<=pivot){
                swap(data,first+1,second);
                first++;
            }
            second++;
        }
        //put the data[start](pivot) on the right place
        swap(data,first,start);
        //return the right index
        return first;
    }
    private void swap(int[] data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort t = new QuickSort();
        int[] nums = {12,123,14,1,1244,56};
        t.sort(nums,0,nums.length);
        System.out.println(Arrays.toString(nums));

    }
}
