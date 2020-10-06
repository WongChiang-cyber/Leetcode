package YTL;

import java.util.Arrays;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int birth1 = sc.nextInt();
        int birth2 = sc.nextInt();
        int death  = sc.nextInt();
        int years  = sc.nextInt();
        int[] a = new int[death];
        a[0] = 1;
        for (int i = 0; i < years-1; i++) {
            System.out.println("year"+i+ Arrays.toString(a));
            int[] b = new int[a.length];
            for (int j = 0; j < death-1; j++) {
                b[j+1] = a[j];
                if(j+1==birth1-1){
                    b[0] += a[j];
                }else if(j+1==birth2-1){
                    b[0] += a[j];
                }
            }
            a = b;
        }
        int res = 0;
        for (int i = 0; i < a.length - 1; i++) {
            res += a[i];
        }
        System.out.println(res);
    }
}
