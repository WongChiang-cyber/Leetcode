package QNER;
import java.util.Scanner;

public class Main01 {

    public static long choose(int m,int n){
        if(n==0)
            return 0;
        int a = 1;
        int b = n;
        int c = m-n+1;
        int d = m;

        int start = Math.min(a,c);
        int end = Math.max(a,c);
        long resN = 1;
        for (int i = start; i < end; i++) {
            resN *= i;
        }
        //System.out.println(resN);

        start = Math.min(b,d);
        end = Math.max(b,d);
        long resM = 1;
        for (int i = start+1; i <= end ; i++) {
            resM *= i;
        }

        return resM/resN;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(choose(m,n));
    }
}

