package test;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int K = sc.nextInt();
            //System.out.println(list);
            HashMap<String,Integer> map = new HashMap<String,Integer>();
            for (int i = 0; i < N; i++) {
                int num = 0;
                String str = sc.next();
                if(map.containsKey(str)){
                    num = map.get(str);
                    map.put(str,num+1);
                }else{
                    map.put(str,1);
                }
            }
            //sort the map
            ArrayList<Map.Entry<String,Integer>> list2 = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
            list2.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o1.getValue()==o2.getValue()){
                        return o1.getKey().compareTo(o2.getKey());
                    }else{
                        return o2.getValue() - o1.getValue();
                    }
                }
            });
            //output the last kth
            for (int i = 0; i < K; i++) {
                int index = list2.size()-1;
                System.out.println(list2.get(i).getKey()+" "+list2.get(i).getValue());
            }
            //sort the map
            ArrayList<Map.Entry<String,Integer>> list1 = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
            list1.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o1.getValue()==o2.getValue()){
                        return o1.getKey().compareTo(o2.getKey());
                    }else{
                        return o1.getValue() - o2.getValue();
                    }
                }
            });
            //output the first kth
            for (int i = 0; i < K; i++) {
                System.out.println(list1.get(i).getKey()+" "+list1.get(i).getValue());
            }
        }
    }
}
