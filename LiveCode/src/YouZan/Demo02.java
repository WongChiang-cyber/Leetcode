package YouZan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Demo02 {

    public int sum = 0;
    String str = "";
    ArrayList<Integer> list = new ArrayList<>();

    public String largestMultipleOfThree (ArrayList<Integer> digits) {
        // write code here
        digits.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        LinkedList<Integer> path = new LinkedList<>();
        LinkedList<Integer> left = new LinkedList<>();
        for (int i = 0; i < digits.size() ;i++) {
            left.addLast(digits.get(i));
        }
        find(path,left);
        for (int i = 0; i < list.size(); i++) {
            str = str+list.get(i);
        }
        return str;
    }

    public void find(LinkedList<Integer> path, LinkedList<Integer> left){
        if(isThree(path)){
            //System.out.println(path.toString());
            if(path.size()>list.size()){
                //str = path.toString();
                list = new ArrayList<>(path);
            }

        }
        //加入left的首个
        Integer num = 0;
        if(left.size()>0){
            num = left.remove(0);
            //path 包含num
            path.add(num);
            find(path,left);
            //path  不包含num
            path.removeLast();
            find(path,left);
            //恢复
            left.addFirst(num);
        }
    }

    boolean isThree(LinkedList<Integer> path){
        sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum+=path.get(i);
        }
        return sum%3==0;
    }

    public static void main(String[] args) {
        Demo02 t = new Demo02();
        int[] nums = {8,1,2,3};
        ArrayList<Integer> digits = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            digits.add(nums[i]);
        }
        System.out.println(t.largestMultipleOfThree(digits));
    }
}
