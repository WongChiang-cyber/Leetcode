package JZcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class JZ48_LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        //initialize hashmap
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        //initialize dp
        int[] dp = new int[s.length()];
        int[] start = new int[s.length()];
        dp[0] = 1;
        start[0] = 0;
        hashMap.put((int) s.charAt(0),0);
        int max = dp[0];
        //(when character[?]==-1)
            //dp[i] = dp[i-1]+1
        //(when character[?]!=-1)
            // if((i-1)-samePos<=dp[i-1]) then same character contains in dp[i-1] then dp[i] = i-samePos;
            // else dp[i] = dp[i-1]+1
        for (int i = 1; i < s.length(); i++) {
            int character = (int)s.charAt(i);
            if(!hashMap.containsKey(character)){
                dp[i] = dp[i-1]+1;
                start[i] = start[i-1];
                hashMap.put(character,i);
            }else{
                int samePos = hashMap.get(character);
                if((i-1)-samePos<=dp[i-1]){
                    dp[i] = i-samePos;
                    start[i] = samePos+1;
                    hashMap.put(character,i);
                }else{
                    dp[i] = dp[i-1]+1;
                    start[i] = start[i-1];
                    hashMap.put(character,i);
                }
            }
            if(dp[i]>max){
                max = dp[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(start));
        return max;
    }

    public static void main(String[] args) {
        int max = lengthOfLongestSubstring("abc#abc#");
    }
}
