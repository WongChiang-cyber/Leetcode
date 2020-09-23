package JZcodes;

import java.util.Scanner;
import java.util.Stack;

public class JZ58_reverseWords {
    public String reverseWords(String s) {
        Scanner sc = new Scanner(s);
        Stack<String> stack = new Stack<>();
        while(sc.hasNext()){
            stack.push(sc.next());
        }
        String res = "";
        while(!stack.isEmpty()){
            res = res.concat(stack.pop());
            res = res.concat(" ");
        }
        if(res.length()>0)
            res = res.substring(0,res.length()-1);
        return res;
    }

    public static void main(String[] args) {
        JZ58_reverseWords t = new JZ58_reverseWords();
        System.out.println(t.reverseWords(""));
    }
}
