package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LC3_LongestSubString_2 {

    public int lengthOfLongestSubstring(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<s.length()){
            String cur = s.substring(right,right+1);
            right++;
            if(map.containsKey(cur) && map.get(cur)>=left){
                left = map.get(cur);
                map.put(cur,right);
            }
            else
                map.put(cur,right);
            res = Math.max(right-left,res);
            System.out.println("window ["+left+","+right+") "+s.substring(left,right));
        }
        return res;
    }

    public static void main(String[] args) {
        LC3_LongestSubString_2 test = new LC3_LongestSubString_2();
        System.out.println(test.lengthOfLongestSubstring("abba"));
    }
}
