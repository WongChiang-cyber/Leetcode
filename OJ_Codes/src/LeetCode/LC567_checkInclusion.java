package LeetCode;

import java.util.HashMap;

class LC567_checkInclusion{
    public boolean checkInclusion(String s1, String s2) {
        HashMap<String,Integer> needs = new HashMap<>();
        HashMap<String,Integer> window = new HashMap<>();
        for(int i = 0;i<s1.length();i++){
            String cur = s1.substring(i,i+1);
            needs.put(cur,needs.getOrDefault(cur,0)+1);
        }

        int right = 0,left = 0;
        int valid = 0;
        while(right<s2.length()){
            //extend window
            String cur = s2.substring(right,right+1);
            right++;
            if(needs.containsKey(cur)){
                window.put(cur,window.getOrDefault(cur,0)+1);
                if(window.getOrDefault(cur,0).equals(needs.get(cur))){
                    valid++;
                }
            }

            //if width<s1 continue not shrink
            /*if(right-left<s1.length())
                continue;*/

            while(right-left>s1.length()){
                String leftStr = s2.substring(left,left+1);
                left++;
                if(needs.containsKey(leftStr)){
                    if(window.get(leftStr).equals(needs.get(leftStr))){
                        valid--;
                    }
                    window.put(leftStr,window.get(leftStr)-1);
                }
            }

            //System.out.println("cur window["+left+""+","+right+") "+s2.substring(left,right));

            if(valid==needs.size())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC567_checkInclusion t = new LC567_checkInclusion();
        System.out.println(t.checkInclusion("abcdxabcde",
                "abcdeabcdx"));
    }
}
