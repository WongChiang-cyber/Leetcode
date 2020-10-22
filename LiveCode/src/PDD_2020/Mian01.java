package PDD_2020;

import java.math.BigInteger;
import java.util.Scanner;

public class Mian01 {

    public static long choose(int m,int n){
        if(n==0 || n==0){
            System.out.println(1);
            return 0;
        }
        //calculate n!
        byte[] bytes = new byte[100];
        bytes[99] = 1;
        BigInteger resN = new BigInteger(bytes);
        for (int i = 1; i <= n; i++) {
            Integer integer = i;
            byte[] numi = integer.toString().getBytes();
            for (int j = 0; j < numi.length; j++) {
                if(numi[j]!=0)
                    numi[j] -= '0';
            }
            resN = resN.multiply(new BigInteger(numi));
            //System.out.println(resN.intValue());
        }
        //System.out.println("resN="+resN.toString());
        //calculate m!
        byte[] bytes2 = new byte[100];
        bytes2[99] = 1;
        BigInteger resM = new BigInteger(bytes2);
        int j = m;
        for (int i = 0; i < n; i++) {
            Integer integer = j;
            byte[] numi = integer.toString().getBytes();
            for (int k = 0; k < numi.length; k++) {
                if(numi[k]!=0)
                    numi[k] -= '0';
            }
            BigInteger resK = new BigInteger(numi);
            System.out.println(resK);
            resM = resM.multiply(resK);
            j--;
            //System.out.println(resN.intValue());
        }
        //System.out.println("resM="+resM.toString());

        System.out.println(resM.divide(resN));
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        choose(m,n);
    }
}
