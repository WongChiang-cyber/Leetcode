package Baidu;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int[][] dp = new int[row+1][column+1];
        for (int i = 0; i < column; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = 0;
        }
        //start dp
        int res = 0;
        for (int i = 1; i < row+1; i++) {
            String rowStr = sc.next();
            for (int j = 1; j < column+1; j++) {
                char c = rowStr.charAt(j-1);
                if(c=='M'){
                    int a = Math.min(dp[i][j-1],dp[i-1][j]);
                    int b = Math.min(a,dp[i-1][j-1]);
                    dp[i][j] = b+1;
                    res = Math.max(dp[i][j],res);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println((int)Math.pow(res,2));
    }
}
