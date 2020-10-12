package Baidu;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int posNum = sc.nextInt();
        int k = sc.nextInt();
        int[] stop = new int[posNum+1];
        for (int i = 0; i < stop.length; i++) {
            stop[i] = sc.nextInt();
        }
        int[] dis = new int[posNum+1];
        int rest = k;
        int pay = 0;
        for (int i = 0; i < dis.length; i++) {
            if(i==0)
                dis[i] = stop[i];
            else
                dis[i] = stop[i]-stop[i-1];
            if(rest>=dis[i])
                rest -= dis[i];
            else{
                pay++;
                rest = k;
                rest -= dis[i];
            }
        }
        System.out.println(sum-pay);
    }
}
