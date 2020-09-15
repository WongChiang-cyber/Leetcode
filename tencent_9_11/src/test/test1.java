package test;

import java.util.ArrayList;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int length1 = sc.nextInt();
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < length1; i++) {
                list1.add(sc.nextInt());
            }
            int length2 = sc.nextInt();
            ArrayList<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < length2; i++) {
                list2.add(sc.nextInt());
            }
            if(length1==0 || length2 == 0)
                continue;
            ArrayList<String> res = new ArrayList<>();
            int p1 = 0,p2 = 0;
            while(p1<list1.size() && p2<list2.size()){
                int a = list1.get(p1);
                int b = list2.get(p2);
                if(a==b){
                    //found same character
                    res.add(String.valueOf(a));
                    p1++;
                    p2++;
                }else if(a>b){
                    p1++;
                }else{
                    p2++;
                }
            }
            int i = 0;
            if(res.size()>0){
                for (i = 0; i < res.size()-1; i++) {
                    System.out.print(res.get(i));
                    System.out.print(" ");
                }
                System.out.println(res.get(i));
            }else
                System.out.println("");
        }
    }
}
