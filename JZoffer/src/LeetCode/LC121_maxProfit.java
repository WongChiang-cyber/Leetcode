package LeetCode;

public class LC121_maxProfit {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int maxProfit = 0;
        int minPurchase = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit,prices[i]-minPurchase);
            minPurchase = Math.min(minPurchase,prices[i]);
        }
        return maxProfit;
    }
}
