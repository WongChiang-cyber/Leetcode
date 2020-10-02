package LeetCode;

import java.util.Arrays;

public class LC215_findKthLargrst_LargeHeap {
    public int findKthLargest(int[] nums, int k) {
        if(nums==null || nums.length == 0 || k>nums.length)
            return -1;
        int find = -1;
        int start = 0;
        int end = nums.length;
        while(find!=k){
            find = patration(nums,start,end);
            if(find==k)
                return nums[k-1];
            else if(k<find){
                end = find-1;
            }else{
                start = find;
            }
        }
        return -1;
    }

    private  int patration(int[] nums,int start,int end){
        if(start>=end)
            return -1;
        int index = (start+end)/2;
        int target = nums[index];
        swap(nums,index,start);
        //start exchange
        int slow = start + 1;
        int fast = start + 1;
        while(fast<end){
            if(nums[fast]>target){
                swap(nums,fast,slow);
                slow++;
            }
            fast++;
        }
        swap(nums,start,slow-1);
        System.out.println("target:"+target+" nums:"+ Arrays.toString(nums));
        return slow;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LC215_findKthLargrst_LargeHeap t = new LC215_findKthLargrst_LargeHeap();
        int[] nums = {1,1,2,2};
        System.out.println(t.findKthLargest(nums,3));
    }

}