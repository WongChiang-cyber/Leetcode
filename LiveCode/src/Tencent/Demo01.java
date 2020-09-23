package Tencent;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Demo01 {

    public String analysis(String input){
        int len = input.length();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if(input.charAt(i)!=']'){
                stack.push(input.substring(i,i+1));
            }else{
                //find the '['
                String newStr = "";
                String repeat = "";
                while(!stack.empty()){
                    String topStr = stack.pop();
                    if(topStr.equals("|")){
                        String number;
                        while(!(number = stack.pop()).equals("[")){
                            repeat = number.concat(repeat);
                        }
                        break;
                    }else{
                        newStr = topStr.concat(newStr);
                    }
                }
                stack.push(multiStr(newStr,Integer.parseInt(repeat)));
            }
        }
        String res = "";
        while(!stack.empty()){
            res = res.concat(stack.pop());
        }
        return res;
    }

    private boolean isNum(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)<'0' || str.charAt(i)>'9')
                return false;
        }
        return true;
    }

    private String multiStr(String str,int num){
        String res = "";
        for (int i = 0; i < num; i++) {
            res = res.concat(str);
        }
        return res;
    }

    public static void main(String[] args) {
        String test = "HG[3|B[2|CA]]F";
        Demo01 d = new Demo01();
        System.out.println(d.analysis(test));
    }
}
