package JZcodes;

import java.util.Arrays;

public class JZ29_spiralOrder_2 {
    public int[][] spiralOrder(int m,int n) {
        int u = 0;
        int d = m-1;
        int l = 0;
        int r = n-1;
        int[][] matrix = new int[m][n];
        int id = 0;
        while(true){
            for (int i = l; i <= r; i++) {
                matrix[u][i] = id++;
            }
            if(++u>d)
                break;
            for (int i = u; i <= d; i++) {
                matrix[i][r] = id++;
            }
            if(--r<l)
                break;
            for (int i = r; i >= l; i--) {
                matrix[d][i] = id++;
            }
            if(--d<u)
                break;
            for (int i = d; i >= u; i--) {
                matrix[i][l] = id++;
            }
            if(++l>r)
                break;
        }
        return matrix;
    }

    public static void main(String[] args) {
        JZ29_spiralOrder_2 t = new JZ29_spiralOrder_2();
        int[][] res = t.spiralOrder(3,4);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
