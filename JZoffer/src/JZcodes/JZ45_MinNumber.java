package JZcodes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class JZ45_MinNumber {
    public static String minNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Long res1 = contract(o1,o2);
                Long res2 = contract(o2,o1);
                return res1.compareTo(res2);
            }
        });
        StringBuilder res = new StringBuilder();
        for(Integer integer:list){
            res.append(String.valueOf(integer));
        }
        return res.toString();
    }

    private static long contract(Integer o1,Integer o2){
        String str1 = String.valueOf(o1);
        String str2 = String.valueOf(o2);
        return Long.parseLong(str1+str2);
    }

    public static void main(String[] args) {
        int[] a = {3,30,34,5,9};
        System.out.println(minNumber(a));
    }
}
