package LeetCode;

import java.util.Arrays;

public class LC322_coinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int index = i - coin;
                if (index >= 0 && dp[index] != -1)
                    min = Math.min(dp[index] + 1, min);
            }
            dp[i] = min==Integer.MAX_VALUE?-1:min;
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
        LC322_coinChange t =  new LC322_coinChange();
        int[] test = {2};
        System.out.println(t.coinChange(test,3));
    }


}
