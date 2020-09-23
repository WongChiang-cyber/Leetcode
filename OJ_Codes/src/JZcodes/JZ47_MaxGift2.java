package JZcodes;

public class JZ47_MaxGift2 {
    public static int maxValue(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        if(grid[0]==null||grid[0].length==0)
            return 0;
        int columns = grid[0].length;
        int lines = grid.length;
        int[] dp = new int[columns];
        dp[0] = grid[0][0];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                int up,left;
                if(i==0){
                    up = 0;
                }else{
                    up = dp[j];
                }
                if(j==0){
                    left = 0;
                }else{
                    left = dp[j-1];
                }
                dp[j] = Math.max(up,left)+grid[i][j];
            }
        }
        return dp[columns-1];
    }

}
