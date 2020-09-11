package JZcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class JZ59_maxSlidingWindow2 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] first_three = new int[1];
        if(nums==null || nums.length==0)
            return new int[0];
        LinkedList<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList();
        deque.add(nums[0]);
        res.add(nums[0]);
        //start slid
        for (int j = 1; j < nums.length; j++) {
            int current = nums[j];
            if(deque.getFirst()==nums[j])
                deque.removeFirst();
            while(deque.size()>=k || (!deque.isEmpty()&&deque.getLast()<nums[j])){
                deque.removeLast();
            }
            deque.add(nums[j]);
            res.add(deque.getFirst());
        }
        System.out.println(res.toString());
        if(nums.length<k){
            return new int[]{res.get(nums.length-1)};
        }else{
            int[] result = new int[res.size()-k+1];
            for (int i = 0; i < result.length; i++) {
                result[i] = res.get(i+k-1);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,2,4};
        int[] res = maxSlidingWindow(nums,2);
        System.out.println(Arrays.toString(res));
    }
}
