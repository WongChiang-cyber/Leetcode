package LeetCode;

public class LC198_robII {
    public int rob(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int res1 = find(nums,0,nums.length-1);
        int res2 = find(nums,1,nums.length);
        return Math.max(res1,res2);
    }

    public int find(int[] nums,int start,int end) {
        if(start>=end)
            return 0;
        int[][] dp = new int[end-start][2];
        dp[0][0] = 0;
        dp[0][1] = nums[start];
        for(int i = 1;i<end-start;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + nums[i+start];
        }
        return Math.max(dp[dp.length-1][1],dp[dp.length-1][0]);
    }

    public static void main(String[] args) {
        LC198_robII t = new LC198_robII();
        int[] nums = {1,2,1,1};
        System.out.println(t.rob(nums));
    }

}
