package LeetCode;

public class LC695_maxAreaIsland {

    /**
    * @Description: 海洋中的最大岛屿
    * @Param: [grid]
    * @return: int
    * @Author: WongChiang
    * @Date: 2020/10/8
    */
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid[0]==null)
            return 0;
        int res = 0;
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j]!=0)
                    res = Math.max(res,find(grid,i,j,0));
            }
        }
        return res;
    }

    private int find(int[][] grid,int row,int column,int current_res){
        if (row<0 || row>=grid.length || column<0 || column>=grid[0].length)
            return current_res;
        if(grid[row][column]!=1)
            return current_res;
        else{
            current_res += 1;
            grid[row][column] = -1;
        }
        //find up down left right
        current_res = Math.max(current_res,find(grid,row-1,column,current_res));
        current_res = Math.max(current_res,find(grid,row+1,column,current_res));
        current_res = Math.max(current_res,find(grid,row,column-1,current_res));
        current_res = Math.max(current_res,find(grid,row,column+1,current_res));
        return current_res;
    }

    public static void main(String[] args) {
        LC695_maxAreaIsland t = new LC695_maxAreaIsland();
        int[][] grid = {
                {0,1,0,0,0},
                {0,1,1,1,0},
                {0,1,0,0,0},
                {0,0,0,1,0}
        };
        System.out.println(t.maxAreaOfIsland(grid));
    }
}
