package JZcodes;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ57II_TwoSum {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] nums = new int[(target+1)/2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        int right = 1;
        int left = 0;
        while(left<right && right < nums.length){
            int sum = calSum(nums,left,right);
            if(sum==target){
                list.add(Arrays.copyOfRange(nums,left,right+1));
                right++;
            }else if(sum>target){
                left++;
            }else{
                right++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int calSum(int[] nums,int start,int end){
        int res = 0;
        for (int i = start; i <= end; i++) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        JZ57II_TwoSum T = new JZ57II_TwoSum();
        int[][] res = T.findContinuousSequence(3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
