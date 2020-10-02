package LeetCode;

import java.util.Arrays;

public class LC312_maxCoins {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[] points = new int[len+2];
        points[0] = 1;
        System.arraycopy(nums, 0, points, 1, len);
        points[len+1] = 1;
        System.out.println(Arrays.toString(points));
        int[][] dp = new int[len+2][len+2];
        for (int i = len; i >= 0 ; i--) {
            for (int j = i+1; j < len+2; j++) {
                for (int k = i + 1; k < j; k++) {
                    // 择优做选择
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + points[i]*points[j]*points[k]
                    );
                }
            }
        }
        return dp[0][len+1];
    }
}
