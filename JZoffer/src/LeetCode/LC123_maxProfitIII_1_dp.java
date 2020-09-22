package LeetCode;

import java.util.Arrays;

public class LC123_maxProfitIII_1_dp {
    public int maxProfit(int[] prices,int fee) {
        int res = 0;
        if(prices==null || prices.length==0)
            return res;
        int[] hold = new int[prices.length];
        int[] cash = new int[prices.length];
        hold[0] = -prices[0];
        cash[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            cash[i] = Math.max(cash[i-1],hold[i-1] + prices[i] - fee);
            hold[i] = Math.max(hold[i-1],cash[i-1] - prices[i]);
        }
        System.out.println("cash"+Arrays.toString(cash));
        System.out.println("hold"+Arrays.toString(hold));
        return cash[prices.length-1];
    }

    public static void main(String[] args) {
        LC123_maxProfitIII_1_dp t = new LC123_maxProfitIII_1_dp();
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(t.maxProfit(prices,2));
    }
}
