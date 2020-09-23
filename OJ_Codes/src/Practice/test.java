package Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put((int)'a',0);
        map.put((int)'a',1);
        map.put((int)'b',2);
        System.out.println(null==null);
        System.out.println('a');
        System.out.println(map.get((int)'a'));
        System.out.println(map);
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.binarySearch(a,2));


    }
}
