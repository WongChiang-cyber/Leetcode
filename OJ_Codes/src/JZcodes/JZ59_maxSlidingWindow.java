package JZcodes;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ59_maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0)
            return new int[0];
        int maxInWindow = nums[0];
        for (int i = 0; i <= nums.length-k; i++) {
            //compare in slide window
            maxInWindow = nums[i];
            for (int j = i; j < i+k; j++) {
                if(nums[j] > maxInWindow){
                    maxInWindow = nums[j];
                }
            }
            res.add(maxInWindow);
        }
        int[] resArray = new int[res.size()];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(res));
    }
}
