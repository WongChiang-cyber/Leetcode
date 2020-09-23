package JZcodes;

import java.util.Arrays;

public class JZ64_twoSum2 {
    public double[] twoSum(int n) {
        int[] dp = new int[n*6+1];
        double[] res = new double[n*5+1];
        int sum = (int)Math.pow(6,n);
        for (int i = 1; i <= 6; i++) {
            dp[i] = 1;
        }
        if(n==1){
            for (int i = n; i <= 6*n ; i++) {
                res[i-n] = (double)dp[i] / Math.pow(6,n);
            }
            return res;
        }
        //投掷次数大于2 填充dp
        for (int i = 2; i <= n ; i++) {
            //第i次投骰子 加和为j
            for (int j = 6*i; j >= i ; j--) {
                dp[j] = 0;
                for (int k = 1; k <= 6; k++) {
                    if(j-k>=0)
                        dp[j] += dp[j-k];
                }
                System.out.println("sum i = "+i+" j="+j);
                System.out.println(Arrays.toString(dp));
            }
        }
        //计算概率
        for (int i = n; i <= 6*n ; i++) {
            res[i-n] = (double)dp[i] / Math.pow(6,n);
        }
        return res;
    }

    public static void main(String[] args) {
        JZ64_twoSum2 sum = new JZ64_twoSum2();
        double[] res = sum.twoSum(3);
        System.out.println(Arrays.toString(res));
    }
}
