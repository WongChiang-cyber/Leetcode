package JZcodes;


import java.util.Arrays;
import java.util.Random;

public class Partration {
    public static int partration(int[] data,int start,int end){
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

//    public static void main(String[] args) {
//        int[] data = {2,1,4,7,5,8,3,6};
//        int index = partration(data,0,data.length);
//        System.out.println(index);
//        System.out.println(Arrays.toString(data));
//    }
}
