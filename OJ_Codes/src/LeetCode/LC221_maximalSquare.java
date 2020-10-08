package LeetCode;

import java.util.Arrays;

public class LC221_maximalSquare {
    /**
    * @Description:  找到矩阵中最大的正方形的边长
    * @Param: [matrix]
    * @return: int
    * @Author: WongChiang
    * @Date: 2020/10/8
    */
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        //base case
        int res = 0;
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0]-'0';
            res = Math.max(dp[i][0], res);
        }
        for (int i = 0; i < column; i++) {
            dp[0][i] = matrix[0][i]-'0';
            res = Math.max(dp[0][i], res);
        }
        //start dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if(matrix[i][j]=='1'){
                    int a = Math.min(dp[i-1][j],dp[i][j-1]);
                    int b = Math.min(dp[i-1][j-1],a);
                    dp[i][j] = b+1;
                }else {
                    dp[i][j] = 0;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        /*for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/
        return (int)Math.pow(res,2);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        LC221_maximalSquare t = new LC221_maximalSquare();
        t.maximalSquare(matrix);
    }
}
