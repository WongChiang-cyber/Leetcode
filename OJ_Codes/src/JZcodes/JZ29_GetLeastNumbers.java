package JZcodes;

import java.util.ArrayList;
import java.util.Random;

public class JZ29_GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input==null)
            return res;
        if(k>input.length||k<=0)
            return res;
        int index = -1;
        int start = 0,end = input.length;
        while(index!=k){
            index = partration(input,start,input.length);
            if(index>k){
                end = index-1;
                index = partration(input,start,end);
            }else if(index<k){
                start = index+1;
                index = partration(input,start,end);
            }else{
                break;
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private static int partration(int[] data,int start,int end){
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
    private static void swap(int[] data,int i,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = {2,1,5,4};
        System.out.println(GetLeastNumbers_Solution(input,3));
    }
}
