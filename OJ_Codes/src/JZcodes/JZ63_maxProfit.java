package JZcodes;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ63_maxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i] - min;
            if(sell>dp[i-1])
                dp[i] = sell;
            else
                dp[i] = dp[i-1];
            if(prices[i]<min)
                min = prices[i];
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] prices = {};
        JZ63_maxProfit max = new JZ63_maxProfit();
        System.out.println(max.maxProfit(prices));
    }
}
