package JZcodes;

import java.util.HashSet;
import java.util.Stack;

public class JZ31_valadateStack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        int pushPos = 0;
        for (int i = 0; i < popped.length; i++) {
            int popNum = popped[i];
//            if(!set.contains(popNum){
//                while(pushed[pushPos]!=popNum){
//                    stack.push(pushed[pushPos]);
//                    set.add(pushed[pushPos++]);
//                }
//            }else{
//
//            }
        }
        return false;
    }
}
