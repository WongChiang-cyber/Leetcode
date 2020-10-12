package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LC438_findAnagrams {
    /**
    * @Description: 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *  示例 2:
     *
     * 输入:
     * s: "abab" p: "ab"
     *
     * 输出:
     * [0, 1, 2]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词.
    * @Param: [s, p]
    * @return: java.util.List<java.lang.Integer>
    * @Author: WongChiang
    * @Date: 2020/10/12
    */
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<String,Integer> needs = new HashMap<>();
        HashMap<String,Integer> window = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            String cur = p.substring(i,i+1);
            needs.put(cur,needs.getOrDefault(cur,0)+1);
        }

        int left = 0,right = 0;
        int valid = 0;
        while(right<s.length()){
            String cur = s.substring(right,right+1);
            right++;
            if(needs.containsKey(cur)){
                window.put(cur,window.getOrDefault(cur,0)+1);
                if(window.get(cur).equals(needs.get(cur)))
                    valid++;
            }

            while(right-left>p.length()){
                String leftStr = s.substring(left,left+1);
                left++;
                if(needs.containsKey(leftStr)){
                    if(window.getOrDefault(leftStr,0).equals(needs.get(leftStr)))
                        valid--;
                    window.put(leftStr,window.get(leftStr)-1);
                }
            }

            //System.out.println("after move ["+left+","+right+") "+s.substring(left,right));

            if(valid == needs.size())
                list.add(left);
        }
        return list;
    }

    public static void main(String[] args) {
        LC438_findAnagrams t = new LC438_findAnagrams();
        System.out.println(t.findAnagrams("cbaebabacd",
                "abc"));
    }
}
