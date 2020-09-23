package JZcodes;

import java.util.Arrays;

public class JZ61_isStraight {
    public boolean isStraight(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int num = 0;
        int i;
        for (i = nums.length-1; i > 0; i--) {
            if(nums[i-1]==0)
                break;
            if(nums[i]==nums[i-1])
                return false;
            num+=nums[i]-nums[i-1]-1;
        }
        System.out.println(num);
        if(num==0){
            //不需要大小王
            return true;
        }else
            //尝试大小王能否抵消
            return i>=num;
    }

    public static void main(String[] args) {
        JZ61_isStraight t = new JZ61_isStraight();
        System.out.println(t.isStraight(new int[]{0,0,2,2,5}));
    }
}
