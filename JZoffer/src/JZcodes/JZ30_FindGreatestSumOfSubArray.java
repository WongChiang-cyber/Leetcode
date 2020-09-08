package JZcodes;

public class JZ30_FindGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array==null || array.length==0)
            return -1;
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for (int i = 1; i < array.length; i++) {
            int contain = dp[i-1]+array[i];
            int self = array[i];
            if(contain>=self){
                dp[i] = contain;
            }
            else{
                dp[i] = self;
            }
            //change max
            if(max < dp[i])
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {6};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
