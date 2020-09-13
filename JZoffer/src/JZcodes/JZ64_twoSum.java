package JZcodes;

import java.util.Arrays;

public class JZ64_twoSum {
    public double[] twoSum(int n) {
        double[] res = new double[5*n+1];
        Arrays.fill(res,0);
        double rate = 1.0/6.0;
        rate = Math.pow(rate,n);
        int[] nums = new int[n];
        Arrays.fill(nums,1);
        int maxNum= (int)Math.pow(6,n);
        //System.out.println(maxNum);
        for (int i = 0; i < maxNum; i++) {
            res[nextBySix(nums)-n] += rate;
        }
        return res;
    }


    //这里的方法复杂度为O(n) 复杂度太高
    //calculate current sum and add one
    private int nextBySix(int nums[]){
        int res = 0;
        boolean ifadd = true;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            if(ifadd){
                if(nums[i]==6){
                    nums[i] = 1;
                    ifadd = true;
                }else {
                    nums[i] += 1;
                    ifadd = false;
                }
            }
        }
        //System.out.println(Arrays.toString(nums)+" res:"+res);
        return res;
    }

    public static void main(String[] args) {
        JZ64_twoSum sum = new JZ64_twoSum();
        double[] res = sum.twoSum(11);
        System.out.println(Arrays.toString(res));
    }
}
