package JZcodes;

import java.util.Arrays;
import java.util.HashMap;

public class JZ50_FirstUnique2 {
    public char firstUniqChar(String s) {
        char[] map = new char[256];
        Arrays.fill(map, (char) 0x0);
        for(int i = 0;i<s.length();i++){
            map[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
           if(map[s.charAt(i)]==1)
               return s.charAt(i);
        }
        return ' ';
    }
}
