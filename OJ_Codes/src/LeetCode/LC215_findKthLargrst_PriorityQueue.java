package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC215_findKthLargrst_PriorityQueue {
    public int findKthLargest(int[] nums, int k) {
        if(k>nums.length)
            return -1;
        PriorityQueue<Integer> heap= new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
        }
        for (int i = nums.length; i > k; i--) {
            System.out.println(heap.poll());
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        LC215_findKthLargrst_PriorityQueue t = new LC215_findKthLargrst_PriorityQueue();
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(t.findKthLargest(nums,3));
    }

}