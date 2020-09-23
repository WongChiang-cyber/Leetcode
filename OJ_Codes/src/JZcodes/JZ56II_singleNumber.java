package JZcodes;

import java.util.*;

public class JZ56II_singleNumber {
    public static int singleNumber(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        //add all to hash table
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int value = map.get(nums[i]);
                map.remove(nums[i]);
                map.put(nums[i],value+1);
            }else{
                map.put(nums[i],1);
            }
        }
        //search in hash table
        ArrayList<Map.Entry<Integer,Integer>> list = new ArrayList<>();
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = (Map.Entry<Integer,Integer>)iterator.next();
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,2,3,3,3};
        System.out.println(singleNumber(a));
    }
}
