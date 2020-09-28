package NetEasy;

import java.util.Arrays;
import java.util.Scanner;

public class Demo01 {

    public static int[][] res;
    public static int u,d,l,r;
    public static int num;

    public static boolean printA(int[][] res){
        for (int i = l; i <= r; i++) {
            res[u][i] = num++;
        }
        u++;
        if(u>d)
            return false;
        for (int i = u; i <= d; i++) {
            res[i][r] = num++;
        }
        r--;
        if(r<l)
            return false;
        for (int i = r; i >= l; i--) {
            res[d][i] = num++;
        }
        d--;
        if(d<u)
            return false;
        for (int i = d; i >= u; i--) {
            res[i][l] = num++;
        }
        l++;
        if(l>r)
            return false;
        return true;
    }

    public static boolean printB(int[][] res){
        for (int i = u; i <= d; i++) {
            res[i][l] = num++;
        }
        l++;
        if(l>r)
            return false;

        for (int i = l; i <= r; i++) {
            res[d][i] = num++;
        }
        d--;
        if(d<u)
            return false;

        for (int i = d; i >= u; i--) {
            res[i][r] = num++;
        }
        r--;
        if(r<l)
            return false;

        for (int i = r; i >= l; i--) {
            res[u][i] = num++;
        }
        u++;
        if(u>d)
            return false;


        return true;
    }


    public static int[][] Matrix(int N){
        res = new int[N][N];
        u=0;l=0;
        d=N-1;r=N-1;
        num =1;
        while(true){
            if(!printA(res)){
                break;
            }
            if(!printB(res)){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for (int i = 0; i < c; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            Matrix(N);
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(res[x][y]);
            }
        }
//        res = Matrix(7);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }
    }
}
