package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer>[] list = new ArrayList[m];
            for (int i = 0; i < m; i++) {
                int num = sc.nextInt();
                list[i] = new ArrayList<>();
                for (int j = 0; j < num; j++) {
                    list[i].add(sc.nextInt());
                }
                System.out.print("team "+i+"： ");
                System.out.println(list[i]);
            }
            boolean[] set = new boolean[n];
            Arrays.fill(set, false);
            set[0] = true;
            int num_last = 1;
            int num_current = 1;
            for(int i =0;i<m;i++){
                num_last = num_current;
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < list[j].size(); k++) {
                        //if someone in group is known
                       if(set[list[j].get(k)]){
                           System.out.println("add group "+j);
                           //add other people to set
                           for (int l = 0; l < list[j].size(); l++) {
                               if(!set[list[j].get(l)]){
                                   set[list[j].get(l)] = true;
                                   num_current++;
                               }
                           }
                           break;
                       }
                    }
                }
                if(num_current==num_last)
                    break;
            }
            System.out.println(num_last);
        }
    }
}
