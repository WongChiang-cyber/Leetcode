package JZcodes;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class JZ13_MovingCount_BFS {
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visit[i],false);
        }
        Queue<Integer> queueRow = new LinkedList<Integer>();
        Queue<Integer> queueColumn = new LinkedList<Integer>();
        queueColumn.add(0);
        queueRow.add(0);
        bfs(visit,queueRow,queueColumn,k);
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i][j])
                    res++;
            }
        }
        return res;
    }

    public void bfs(boolean[][] visit,Queue<Integer> queueRow,Queue<Integer> queueColumn,int k){
        while((!queueColumn.isEmpty()) && (!queueRow.isEmpty())){
            int row = queueRow.poll();
            int colunm = queueColumn.poll();
            //if visit contains nothing
            if(visit==null || visit.length == 0 || visit[0]==null || visit[0].length == 0)
                return;
            //index out of bind
            if(countSingle(row)+countSingle(colunm)<=k && !visit[row][colunm]){
                visit[row][colunm] = true;
                if(check(visit,row-1,colunm)){
                    queueRow.add(row-1);
                    queueColumn.add(colunm);
                }
                if(check(visit,row+1,colunm)){
                    queueRow.add(row+1);
                    queueColumn.add(colunm);
                }
                if(check(visit,row,colunm-1)){
                    queueRow.add(row);
                    queueColumn.add(colunm-1);
                }
                if(check(visit,row,colunm+1)){
                    queueRow.add(row);
                    queueColumn.add(colunm+1);
                }
            }
        }
    }

    private boolean check(boolean[][] visit,int row,int column){
        return row>=0 && column>=0 && row < visit.length && column<visit[0].length;
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
        JZ13_MovingCount_BFS t = new JZ13_MovingCount_BFS();
        System.out.println(t.movingCount(20,20,6));
    }
}
