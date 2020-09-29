package JZcodes;

import java.util.Arrays;

public class JZ21_exchange {

    public int[] exchange(int[] nums) {
        int fast =0,slow =0;
        if(nums==null || nums.length==0)
            return nums;
        while(fast<nums.length){
            if((nums[fast]&1)==1){
                //swap
                swap(nums, fast, slow);
                slow++;
            }
            fast++;
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        JZ21_exchange t = new JZ21_exchange();
        int[] nums = {1,2,3,4,5,6,7};
        t.exchange(nums);
        System.out.println(Arrays.toString(nums));
    }
}
