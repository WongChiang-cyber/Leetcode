package PDD_2020;

import java.util.Arrays;
import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        int maxNum = 0;
        int sum = 1;
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
            if(p[i]>maxNum)
                maxNum = p[i];
            sum*=p[i];
        }
        double res = 0;
        for (long i = 1; i <= maxNum; i++) {
            long pre = i;
            long countA = 1,countB = 1;
            //calculate countA
            System.out.printf("\nA: ");
            for (int j = 0; j < p.length; j++) {
                countA*=Math.min(pre,p[j]);
                System.out.printf("%d ",Math.min(pre,p[j]));
            }
            System.out.printf("\nB: ");
            for (int j = 0; j < p.length; j++) {
                countB*=Math.min(pre-1,p[j]);
                System.out.printf("%d ",Math.min(pre-1,p[j]));
            }
            long delt = i==1?1:countA - countB;
            System.out.printf("\npre = %d countA = %d countB = %d delt = %d\n",pre,countA,countB,delt);
            res += ((double)(i*delt)/(double)sum);
        }
        System.out.printf("%.2f", res);


    }
}
