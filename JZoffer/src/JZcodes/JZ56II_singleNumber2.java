package JZcodes;

import java.util.*;

public class JZ56II_singleNumber2 {
    public static int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        Arrays.fill(bitSum,0);
        for (int i = 0; i < nums.length; i++) {
            int mask = 1;
            for (int j = 0; j < 32; j++) {
                bitSum[j] += (nums[i]&mask)==0?0:1;
                mask = mask<<1;
            }
        }
        System.out.println(Arrays.toString(bitSum));
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if(bitSum[i]%3!=0)
                res += Math.pow(2,i);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {5,4,5,5,4,1,4};
        System.out.println(singleNumber(a));
    }
}
