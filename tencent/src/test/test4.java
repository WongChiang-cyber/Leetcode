package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            int max = sc.nextInt();
            for (int i = 0; i < n; i++) {
                sum += list.get(i);
                if(sum>max)
                    break;
            }
            System.out.println(sum);
        }
    }

}
