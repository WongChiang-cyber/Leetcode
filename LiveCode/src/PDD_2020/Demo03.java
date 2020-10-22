package PDD_2020;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<String> listA = new ArrayList<>();
        ArrayList<String> listB = new ArrayList<>();
        String strA = "";
        listA.add("");
        for (int i = 0; i < n; i++) {
            strA = strA.concat("a");
            listA.add(strA);
        }
        String strB = "";
        listB.add("");
        for (int i = 0; i < m; i++) {
            strB = strB.concat("b");
            listB.add(strB);
        }
        //start concat
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < listA.size(); i++) {
            String A = listA.get(i);
            for (int j = 0; j < listB.size(); j++) {
                String B = listB.get(j);
                if(A.equals("")&&B.equals(""))
                    continue;
                list.add(A.concat(B));
            }
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list.toString());
    }
}
