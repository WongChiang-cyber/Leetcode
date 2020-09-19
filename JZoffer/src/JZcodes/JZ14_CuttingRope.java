package JZcodes;

import java.util.Arrays;

public class JZ14_CuttingRope {
    public int cuttingRope(int n) {
        if(n<4) return n-1;
        int[] dp = new int[n+1];
        for (int i = 1; i <= n ; i++) {
            int res = i;
            for (int j = 1; j < i; j++) {
                if(dp[i-j]*j>res)
                    res = dp[i-j]*j;
            }
            dp[i] = res;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        JZ14_CuttingRope t = new JZ14_CuttingRope();
        System.out.println(t.cuttingRope(8));
    }
}
