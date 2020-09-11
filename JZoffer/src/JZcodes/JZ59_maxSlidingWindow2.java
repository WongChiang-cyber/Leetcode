package JZcodes;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ59_maxSlidingWindow2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();
        if(nums==null || nums.length==0)
            return new int[0];
        int currentMax = nums[0];
        //init the first window
        for (int i = 0; i < k; i++) {
            numList.add(nums[i]);
            if(nums[i]>=currentMax){
                maxList.add(nums[i]);
            }else{
                maxList.add(currentMax);
            }
        }
        //start slid
        for (int i = 0; i < nums.length-k; i++) {
            
            numList.add(nums[i]);
            if(nums[i]>currentMax)
                maxList.add(nums[i]);
            else
                maxList.add(currentMax);
        }

        return new int[]{2};
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(res));
    }
}
