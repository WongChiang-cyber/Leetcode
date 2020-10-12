package LeetCode;

import java.util.HashMap;

public class LC76_minWindows {
    public String minWindow(String s, String t) {
        HashMap<String,Integer> needs = new HashMap<>();
        HashMap<String,Integer> windows = new HashMap<>();
        String res = "";
        //initialize needs
        for (int i = 0; i < t.length(); i++) {
            String key = t.substring(i,i+1);
            if(!needs.containsKey(key)){
                needs.put(key,1);
            }else{
                int count = needs.get(key);
                needs.put(key,count+1);
            }
        }
        //start slid
        int left = 0,right = 0;
        int valid = 0;
        while(right<s.length()){
            String cur = s.substring(right,right+1);
            right++;
            //update windows
            if(needs.containsKey(cur)){
                if(!windows.containsKey(cur))
                    windows.put(cur,1);
                else
                    windows.put(cur,windows.get(cur)+1);
                if(windows.get(cur).equals(needs.get(cur)))
                    valid++;
            }
            //if valid update res
            if(valid==needs.size()){
                if((right-left)<res.length() || res.equals(""))
                    res = s.substring(left,right);
            }

            //System.out.println("now window ["+left+","+right+") "+s.substring(left,right));

            //shrink window
            while(valid==needs.size()){
                if((right-left)<res.length() || res.equals(""))
                    res = s.substring(left,right);
                String leftStr = s.substring(left,left+1);
                left++;
                if(needs.containsKey(leftStr)){
                    windows.put(leftStr,windows.get(leftStr)-1);
                    if(windows.get(leftStr)<needs.get(leftStr))
                        valid--;
                }
            }

            //System.out.println("after shrink ["+left+","+right+") "+s.substring(left,right));
            //System.out.println("now res:"+res);
        }

        return res;
    }

    public static void main(String[] args) {
        LC76_minWindows t = new LC76_minWindows();
        System.out.println(t.minWindow("cabwefgewcwaefgcf",
                "cae"));
    }
}
