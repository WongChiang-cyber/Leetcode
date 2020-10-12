package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LC51_solveNQueens {
    public List<List<String>> solveNQueens(int n) {
        ArrayList<QueenNode> path = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        char[][] matrix = new char[n][n];
        //矩阵初始化为全“.”

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }
        traceBack(n,0,0,path,matrix,res);
       /* for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                traceBack(n,i,j,path,matrix,res);
            }
        }*/
        return res;
    }

    private void traceBack(int n,int x,int y,ArrayList<QueenNode> path,char[][] matrix,List<List<String>> res){
        if(y==n){
            x++;y=0;
        }
        if(x==n)
            return;
        //System.out.println("x ="+x+"y="+y+"size = "+path.size());
        //结点加入皇后位置
        QueenNode node = new QueenNode(x,y);
        if(isCompatible(path,x,y)){
            path.add(node);
            matrix[x][y] = 'Q';
            //add a res
            if(path.size()==n){
                addRes(matrix,res);
            }else{
                traceBack(n,x,y+1,path,matrix,res);
            }
            path.remove(path.size()-1);
            matrix[x][y] = '.';
        }

        //结点不加入皇后位置
        matrix[x][y] = '.';
        traceBack(n,x,y+1,path,matrix,res);

    }

    private void addRes(char[][] matrix,List<List<String>> res){
        ArrayList<String> singleRes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix.length; j++) {
                sb.append(String.valueOf(matrix[i][j]));
            }
            singleRes.add(sb.toString());
        }
        res.add(singleRes);
    }

    private boolean isCompatible(ArrayList<QueenNode> path,int x,int y){
        for (QueenNode queenNode : path) {
            if (queenNode.x == x || queenNode.y == y) {
                return false;
            }
            int absX = Math.abs(x - queenNode.x);
            int absY = Math.abs(y - queenNode.y);
            if (absX == absY)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC51_solveNQueens t = new LC51_solveNQueens();
        List<List<String>> res = t.solveNQueens(5);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }
}
class QueenNode{
    int x;
    int y;
    QueenNode(int x,int y){
        this.x = x;
        this.y = y;
    }
}
