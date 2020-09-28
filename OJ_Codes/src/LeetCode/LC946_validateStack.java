package LeetCode;

import java.util.Stack;

public class LC946_validateStack {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed == null || popped == null || pushed.length==0 || popped.length==0)
            return true;
        Stack<Integer> stack = new Stack<>();
        int i =0;
        for(int num:pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LC946_validateStack t = new LC946_validateStack();
        int[] pushed = {1,2,3,4,5};
        int[] poped = {5,4,3,2,1};
        System.out.println(t.validateStackSequences(pushed,poped));
    }
}
