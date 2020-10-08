package JZcodes;

import java.util.Arrays;
import java.util.Random;

public class JZ40_getLeastNums {

    public int[] getLeastNumbers(int[] arr, int k) {
        patration(arr,0,arr.length-1,k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    private int patration(int[] nums,int start,int end,int k){
        if(start==end)
            return k;
        Random r = new Random();
        int index = r.nextInt(end-start)+start;
        int pivot = nums[index];
        swap(nums,index,start);
        int slow = start+1;
        int fast = start+1;
        while(fast<=end){
            if(nums[fast]<=pivot){
                swap(nums,fast,slow);
                slow++;
            }
            fast++;
        }
        //下标slow-1为此次调整正确的数字
        index = slow-1;
        swap(nums,start,index);
        if(slow==k){
            return slow;
        }else if(slow<k){
            return patration(nums,slow,end,k);
        }else{
            return patration(nums,start,slow-2,k);
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9};
        JZ40_getLeastNums t = new JZ40_getLeastNums();
        int[] res = t.getLeastNumbers(arr,1);
        System.out.println(Arrays.toString(res));
    }
}
