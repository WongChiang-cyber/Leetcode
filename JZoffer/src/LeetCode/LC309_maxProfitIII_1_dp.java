package LeetCode;

import java.util.Arrays;

public class LC309_maxProfitIII_1_dp {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices==null || prices.length<=1)
            return res;
        int[] hold = new int[prices.length];
        int[] cash = new int[prices.length];
        hold[0] = -prices[0];
        cash[0] = 0;
        cash[1] = Math.max(cash[0],hold[0] + prices[1]);
        hold[1] = Math.max(hold[0], cash[0]-prices[1]);
        for (int i = 2; i < prices.length; i++) {
            cash[i] = Math.max(cash[i-1],hold[i-1] + prices[i]);
            hold[i] = Math.max(hold[i-1],cash[i-2] - prices[i]);
        }
        System.out.println("cash"+Arrays.toString(cash));
        System.out.println("hold"+Arrays.toString(hold));
        return cash[prices.length-1];
    }

    public static void main(String[] args) {
        LC309_maxProfitIII_1_dp t = new LC309_maxProfitIII_1_dp();
        int[] prices = {1,2,3,0,2};
        System.out.println(t.maxProfit(prices));
    }
}
