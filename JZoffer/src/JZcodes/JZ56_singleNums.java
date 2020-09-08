package JZcodes;

import java.util.Arrays;

public class JZ56_singleNums {
    public static int[] singleNumbers(int[] nums) {
        if(nums==null || nums.length==0)
            return null;
        int resTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            resTotal = resTotal^nums[i];
        }
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((mask&resTotal)==0){
                mask = mask << 1;
            }else
                break;
        }
        int resA = 0,resB = 0;
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&mask)!=0){
                resA = resA ^ nums[i];
            }else{
                resB = resB ^ nums[i];
            }
        }
        return new int[]{resA,resB};
    }

    public static void main(String[] args) {
        int[] a = {4,1,4,6};
        System.out.println(Arrays.toString(singleNumbers(a)));
    }
}
