package LeetCode;

public class LC122_maxProfitII_2_dp {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices==null || prices.length==0)
            return res;
        int preCash = 0;
        int preHold = -prices[0];
        int cash = 0;
        int hold = 0;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(preCash,preHold + prices[i]);
            hold = Math.max(preHold,preCash - prices[i]);

            preCash = cash;
            preHold = hold;
        }
        return cash;
    }
}
