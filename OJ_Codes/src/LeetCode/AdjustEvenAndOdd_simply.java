package LeetCode;

import java.util.Arrays;

public class AdjustEvenAndOdd_simply {
    
    /** 
    * @Description: 给定一个长度不小于2的数组arr，实现一个函数调整arr，要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数
     *
     * 注意：1、数组下标从0开始！
     *
     * 2、本题有special judge，你可以输出任意一组合法解！同时可以证明解一定存在
     *
     * [要求]
     *
     * 时间复杂度为O(n)O(n)，额外空间复杂度为O(1)O(1)
    * @Param: [nums] 
    * @return: int[] 
    * @Author: WongChiang
    * @Date: 2020/10/8 
    */ 
    public int[] adjust(int[] nums){
        int end = nums.length-1;
        int even = 1;
        int odd = 0;
        while(even<=end&&odd<=end){
            if((nums[end]&1)==1){
                swap(nums,even,end);
                even+=2;
            }else{
                swap(nums,odd,end);
                odd+=2;
            }
        }
        return nums;
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1};
        AdjustEvenAndOdd_simply t = new AdjustEvenAndOdd_simply();
        t.adjust(nums);
        System.out.println(Arrays.toString(nums));
    }
}
