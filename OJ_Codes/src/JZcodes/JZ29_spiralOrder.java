package JZcodes;

import java.util.Arrays;

public class JZ29_spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return new int[]{};
        int u = 0;
        int d = matrix.length-1;
        int l = 0;
        int r = matrix[0].length-1;
        int[] res = new int[(d+1)*(r+1)];
        int id = 0;
        while(true){
            for (int i = l; i <= r; i++) {
                res[id++] = matrix[u][i];
            }
            if(++u>d)
                break;
            for (int i = u; i <= d; i++) {
                res[id++] = matrix[i][r];
            }
            if(--r<l)
                break;
            for (int i = r; i >= l; i--) {
                res[id++] = matrix[d][i];
            }
            if(--d<u)
                break;
            for (int i = d; i >= u; i--) {
                res[id++] = matrix[i][l];
            }
            if(++l>r)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        JZ29_spiralOrder t = new JZ29_spiralOrder();
        int[][] matrix = {
                {2,5,8},
                {4,0,-1}
        };
        System.out.println(Arrays.toString(t.spiralOrder(matrix)));
    }
}
