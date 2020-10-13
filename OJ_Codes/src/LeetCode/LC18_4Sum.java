package LeetCode;

import java.util.*;

public class LC18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = nSum(4,nums,0,nums.length-1,target);
        return res;
    }

    /**
    * @Description: 需要数组是已经排序好的 在start-end的下标范围内找到 n个加和为target的数组list
    * @Param: [n, nums, start, end]
    * @return: java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
    * @Author: WongChiang
    * @Date: 2020/10/13
    */
    public List<List<Integer>> nSum(int n,int[] nums,int start,int end,int target){
        List<List<Integer>> res = new LinkedList<>();
        if(end-start+1<2){
            return res;
        }
        //base case 是n=2的时候
        if(n==2){
            int left = start;
            int right = end;
            while(left<right){
                int l = nums[left];
                int r = nums[right];
                if(nums[left]+nums[right]<target)
                    while(nums[left]==l && left<right) left++;
                else if(nums[left]+nums[right]>target)
                    while(nums[right]==r && left<right) right--;
                else{
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    while(nums[left]==l && left<right) left++;
                }
            }
            return res;
        }
        //每次选出一个num target = target - num
        int i = start;
        while(i<end) {
            int num = nums[i];
            int next_target = target - nums[i];
            List<List<Integer>> next_res = nSum(n-1,nums,i+1,end,next_target);
            if(next_res!=null){
                for (int j = 0; j < next_res.size(); j++) {
                    next_res.get(j).add(nums[i]);
                }
                res.addAll(next_res);
            }
            while(nums[i]==num && i<end)
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        LC18_4Sum t = new LC18_4Sum();
        int[] nums = {1,0,-1,0,-2,2};
        System.out.println(t.fourSum(nums,0));
    }
}
