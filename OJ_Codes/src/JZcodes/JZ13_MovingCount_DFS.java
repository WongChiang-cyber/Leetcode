package JZcodes;

import java.util.Arrays;

public class JZ13_MovingCount_DFS {
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visit[i],false);
        }
        dfs(visit,0,0,k);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i][j])
                    res++;
            }
        }
        return res;
    }

    public void dfs(boolean[][] visit,int row,int colunm,int k){
        //if visit contains nothing
        if(visit==null || visit.length == 0 || visit[0]==null || visit[0].length == 0)
            return;
        //index out of bind
        if(row >= visit.length || colunm >= visit[0].length || colunm < 0 || row < 0 || visit[row][colunm])
            return;
        if(countSingle(row)+countSingle(colunm)<=k){
            visit[row][colunm] = true;
        }else
            return;
        dfs(visit,row+1,colunm,k);
        dfs(visit,row-1,colunm,k);
        dfs(visit,row,colunm+1,k);
        dfs(visit,row,colunm-1,k);
    }

    public int countSingle(int num){
        int res = 0;
        while(num>0){
            res += num%10;
            num = num/10;
        }
        return res;
    }

    public static void main(String[] args) {
        JZ13_MovingCount_DFS t = new JZ13_MovingCount_DFS();
        System.out.println(t.movingCount(20,20,6));
    }
}
