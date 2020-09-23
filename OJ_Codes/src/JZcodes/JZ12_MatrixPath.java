package JZcodes;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class JZ12_MatrixPath {

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word==null || word.length()==0)
            return false;
        boolean[][] path = new boolean[board.length][board[0].length];
        for (int i = 0; i < path.length; i++) {
            Arrays.fill(path[i],false);
        }
        int rows = board.length;
        int column = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                //System.out.println("====="+i+"============"+j+"=======");
                if(isReachable(board,path,i,j,0,word))
                    return true;
            }
        }
        return false;
    }

    boolean isReachable(char[][] board,boolean [][] path, int pos_row, int pos_column, int index, String word){
        //处理越界的访问
        if(pos_row >= board.length || pos_column >= board[0].length || pos_column < 0 || pos_row < 0)
            return false;
        //判断当前字符是否匹配index个word 并且 这个位置的标记位false
        if(board[pos_row][pos_column] == word.charAt(index) && !path[pos_row][pos_column]){
            //匹配
            path[pos_row][pos_column] = true;
            if(index == word.length()-1){
                return true;
            }else if(index > word.length()-1)
                return false;
            if(isReachable(board, path,pos_row-1, pos_column, index+1, word)||
            isReachable(board, path,pos_row+1, pos_column, index+1, word)||
            isReachable(board, path,pos_row, pos_column-1, index+1, word)||
            isReachable(board, path,pos_row, pos_column+1, index+1, word))
                return true;
            else{
                path[pos_row][pos_column] = false;
                return false;
            }
        }else{
            //不匹配
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'c','A','A'},{'A','A','A'},{'B','C','D'}
        };
        JZ12_MatrixPath T = new JZ12_MatrixPath();
        System.out.println(T.exist(board,"AAB"));
    }

}

