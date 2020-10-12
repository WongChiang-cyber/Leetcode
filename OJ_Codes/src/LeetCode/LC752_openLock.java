package LeetCode;

import java.util.*;

public class LC752_openLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            sb.append("0");
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(sb.toString());
        int step = 0;
        //初始化队列 初始值入队
        while(!queue.isEmpty()){
            int leveLen = queue.size();
            for (int j = 0; j < leveLen; j++) {
                String curNum = queue.poll();
                if(dead.contains(curNum))
                    continue;
                if(curNum.equals(target))
                    return step;
                //8个子节点入队
                for (int i = 0; i < target.length(); i++) {
                    String upNum = upLock(curNum,i);
                    if(upNum.equals(target))
                        return step;
                    if(!visited.contains(upNum)){
                        queue.add(upNum);
                        visited.add(upNum);
                    }
                    String downNum = downLock(curNum,i);
                    if(downNum.equals(target))
                        return step;
                    if(!visited.contains(upNum)){
                        queue.add(downNum);
                        visited.add(downNum);
                    }
                }
            }
            //层数++
            step++;
        }
        return -1;
    }

    private String upLock(String num,int i){
        int nextNum  = ((int)(num.charAt(i)-'0')+1)%10;
        return num.substring(0,i)+nextNum+num.substring(i+1);
    }

    private String downLock(String num,int i){
        int nextNum  = ((int)(num.charAt(i)-'0')-1)%10;
        nextNum = nextNum<0?nextNum+10:nextNum;
        return num.substring(0,i)+nextNum+num.substring(i+1);
    }

    public static void main(String[] args) {
        LC752_openLock t = new LC752_openLock();
        String[] deads = {
                "0201","0101","0102","1212","2002"
        };
        String target = "0202";
        System.out.println(t.openLock(deads,target));
    }

}
