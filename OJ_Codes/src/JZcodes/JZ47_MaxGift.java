package JZcodes;

public class JZ47_MaxGift {
    public static int maxValue(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        if(grid[0]==null||grid[0].length==0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int columns = grid[0].length;
        int lines = grid.length;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                int up,left;
                if(i==0){
                    up = 0;
                }else{
                    up = dp[i-1][j];
                }
                if(j==0){
                    left = 0;
                }else{
                    left = dp[i][j-1];
                }
                dp[i][j] = Math.max(up,left)+grid[i][j];
            }
        }
        return dp[lines-1][columns-1];
    }

}
