package LeetCode;

public class MaxLengthSubstring {
    public int maxLengthSubstring(String a,String b){
        int len_a = a.length()+1;
        int len_b = b.length()+1;
        int[][] dp = new int[len_a][len_b];
        //置0
        for (int i = 0; i < len_a; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < len_b; i++) {
            dp[0][i] = 0;
        }
        //开始dp
        int res = 0;
        for (int i = 1; i < len_a; i++) {
            for (int j = 1; j < len_b; j++) {
                if(a.charAt(i-1)==a.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j],res);
                }else
                    dp[i][j] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxLengthSubstring t = new MaxLengthSubstring();
        System.out.println(t.maxLengthSubstring("hello","hell"));
    }
}
