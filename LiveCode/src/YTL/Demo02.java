package YTL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Demo02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();
        String[] nums = exp.split(" |\\+|\\-|\\*|\\/");
        System.out.println(Arrays.toString(nums));
        ArrayList<String> signs = new ArrayList<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(c=='+'||c=='-'||c=='*'||c=='/'){
                signs.add(String.valueOf(c));
            }
        }
        Stack<String> stack = new Stack<>();
        stack.push(nums[0]);
        int i=1,j=0;
        while(i<nums.length&&j<signs.size()){
            int num = 0;
            char sign = '+';
            if(j<signs.size()){
                sign = signs.get(j).charAt(0);
                stack.push(signs.get(j++));
            }
            if(i<nums.length){
                num = Integer.parseInt(nums[i]);
                stack.push(nums[i++]);
            }
            if(sign=='*'){
                int numA = Integer.parseInt(stack.pop());
                stack.pop();
                int numB = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(numA*numB));
            }else if(sign=='/'){
                int numA = Integer.parseInt(stack.pop());
                stack.pop();
                int numB = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(numB/numA));
            }
        }
        int res = 0;
        while(stack.size()>1){
            int num = Integer.parseInt(stack.pop());
            char sign = stack.pop().charAt(0);
            if(sign=='+'){
                res += num;
            }else{
                res -= num;
            }
        }
        res += Integer.parseInt(stack.pop());
        System.out.println(res);
    }

}
