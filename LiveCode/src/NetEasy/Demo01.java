package NetEasy;

import java.util.Arrays;
import java.util.Scanner;

public class Demo01 {

    public static int[][] res;

    public static int[][] Matrix(int N){
        res = new int[N][N];
        int u=0,l=0;
        int d=N-1,r=N-1;
        int num = 1;
        while(true){
            for (int i = l; i <= r; i++) {
                res[u][i] = num++;
//                num++;
//                if(u==x && i==y)
//                    return num;
            }
            u++;
            if(u>d)
                break;
            for (int i = u; i <= d; i++) {
                res[i][r] = num++;
//                num++;
//                if(i==x && r==y)
//                    return num;
            }
            r--;
            if(r<l)
                break;
            for (int i = r; i >= l; i--) {
                res[d][i] = num++;
//                num++;
//                if(d==x && i==y)
//                    return num;
            }
            d--;
            if(d<u)
                break;
            for (int i = d; i >= u; i--) {
                res[i][l] = num++;
//                num++;
//                if(i==x && l==y)
//                    return num;
            }
            l++;
            if(l>r)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            //System.out.println("N="+N+"M="+M);
            Matrix(N);
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(res[x][y]);
            }
        }
    }
}
