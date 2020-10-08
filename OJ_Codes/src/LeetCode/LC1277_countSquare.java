package LeetCode;

import java.util.Arrays;

public class LC1277_countSquare {
    /**
     * @Description:  找到矩阵中正方形的数目总和
     * @Param: [matrix]
     * @return: int
     * @Author: WongChiang
     * @Date: 2020/10/8
     */
    public int countSquare(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        //base case
        int res = 0;
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0];
            res += dp[i][0];
        }
        for (int i = 1; i < column; i++) {
            dp[0][i] = matrix[0][i];
            res += dp[0][i];
        }
        //start dp
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if(matrix[i][j]==1){
                    int a = Math.min(dp[i-1][j],dp[i][j-1]);
                    int b = Math.min(dp[i-1][j-1],a);
                    dp[i][j] = b+1;
                }else {
                    dp[i][j] = 0;
                }
                res += dp[i][j];
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,0,0},
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,0,0,1,0}
        };
        LC1277_countSquare t = new LC1277_countSquare();
        System.out.println(t.countSquare(matrix));
    }
}
