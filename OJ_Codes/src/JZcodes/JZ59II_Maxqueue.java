package JZcodes;

import java.util.LinkedList;
import java.util.Queue;

public class JZ59II_Maxqueue {

    private LinkedList<Integer> numList;
    private LinkedList<Integer> maxList;

    public JZ59II_Maxqueue() {
        numList = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value() {
        if(!maxList.isEmpty())
            return maxList.peek();
        else
            return -1;
    }

    public void push_back(int value) {
        numList.add(value);
        if(maxList.isEmpty()){
            maxList.add(value);
            return;
        }
        for (int i = maxList.size()-1; i >= 0; i--) {
            if(maxList.getLast()<=value){
                maxList.removeLast();
            }else
                break;
        }
        maxList.add(value);
    }

    public int pop_front() {
        if(numList.isEmpty() || maxList.isEmpty()){
            return -1;
        }
        int num = numList.poll();
        if(maxList.peek()==num){
            maxList.poll();
        }
        return num;
    }

    public String toString(){
        return numList.toString()+"\n"+maxList.toString();
    }

    public static void main(String[] args) {
        JZ59II_Maxqueue queue = new JZ59II_Maxqueue();
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        queue.push_back(1);
        queue.push_back(2);
        System.out.println("now"+queue.toString());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
    }
}
