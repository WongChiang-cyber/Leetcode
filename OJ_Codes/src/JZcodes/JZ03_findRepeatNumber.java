package JZcodes;

import java.util.Arrays;

public class JZ03_findRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==i)
                continue;
            else{
                int temp = nums[i];
                int index = nums[i];
                if(nums[index]==nums[i])
                    return nums[i];
                nums[i] = nums[nums[i]];
                nums[index] = temp;
            }
            System.out.println(Arrays.toString(nums));
        }
        return 0;
    }

    public static void main(String[] args) {
        JZ03_findRepeatNumber t = new JZ03_findRepeatNumber();
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(t.findRepeatNumber(nums));
    }
}
