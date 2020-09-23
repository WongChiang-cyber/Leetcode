package JZcodes;

import java.util.Arrays;

public class JZ57_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                return new int[]{nums[left],nums[right]};
            }
            if(nums[left]+nums[right]>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        JZ57_TwoSum t = new JZ57_TwoSum();
        int[] a = {10,26,30,31,47,60};
        System.out.println(Arrays.toString(t.twoSum(a,1)));
    }
}
