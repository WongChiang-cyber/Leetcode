package JZcodes;

import java.util.Scanner;
import java.util.Stack;

public class JZ58_reverseWords2 {
    public String reverseWords(String s) {
        if(s.equals("")) return s;
        String str = s.trim();
        String arr[] = str.split(" ");
        StringBuilder sb = new StringBuilder(arr.length);
        for (int i = arr.length-1; i >= 1; i--) {
            if(!arr[i].equals(""))
                sb.append(arr[i].concat(" "));
        }
        sb.append(arr[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        JZ58_reverseWords2 t = new JZ58_reverseWords2();
        System.out.println(t.reverseWords("a good   example"));
    }
}
