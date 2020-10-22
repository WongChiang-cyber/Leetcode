package QNER;
import java.util.Scanner;

public class Main {

    public static int choose(int m,int n){
        if(n==0)
            return 0;
        //calculate n!
        int resN = n==0?0:1;
        for (int i = 1; i <= n; i++) {
            resN *= i;
        }
        System.out.println("resN="+resN);
        int resM = m==0?0:1;
        int j = m;
        for (int i = 0; i < n; i++) {
            resM *= j;
            j--;
        }
        System.out.println("resM="+resM);
        return resN==0?0:resM/resN;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(choose(m,n));
    }
}

