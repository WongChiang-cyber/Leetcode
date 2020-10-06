package LeetCode;

import java.util.Scanner;

public class PrintDiamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        int space = num/2;
        for (int i = space; i >= 0; i--) {
            int starNum = num-i*2;
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < starNum; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= space; i++) {
            int starNum = num-i*2;
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < starNum; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
