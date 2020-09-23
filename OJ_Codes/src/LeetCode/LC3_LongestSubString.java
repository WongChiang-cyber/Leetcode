package LeetCode;

import java.util.Arrays;

public class LC3_LongestSubString {
    //这里使用了一个存储字符上次出现位置的下一个的数组 相当于HashMap的方法
    //在窗口滑动过程中，如果遇到了相同的字符，则start更新为窗口内相同字符的下标的后一个
    public int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        int[] position = new int[256];
        Arrays.fill(position,0);
        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            //get the position of this char last appear
            int pos = position[s.charAt(i)];
            start = Math.max(start,pos);
            res = Math.max(res,i-start+1);
            position[s.charAt(i)] = i+1;
        }
        return res;
    }

    public static void main(String[] args) {
        LC3_LongestSubString test = new LC3_LongestSubString();
        System.out.println(test.lengthOfLongestSubstring("au"));
    }
}
