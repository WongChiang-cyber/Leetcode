package LeetCode;

import java.util.Arrays;

public class AdjustEvenAndOdd {
    
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
        int head = 0;
        int tail = nums.length-1;
        while(head<nums.length && tail>= 0){
            while (head<nums.length){
                if((nums[head]&1)==1 && (head&1)==0){
                    //找到下一个不满足条件的奇数数字
                    break;
                }
                head++;
            }
            while(tail>=0){
                if((nums[tail]&1)==0 && (tail&1)==1){
                    //找到下一个不满足条件的偶数数字
                    break;
                }
                tail--;
            }
            if(head<nums.length && tail>= 0)
                swap(nums,head,tail);
            head++;
            tail--;
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
        AdjustEvenAndOdd t = new AdjustEvenAndOdd();
        t.adjust(nums);
        System.out.println(Arrays.toString(nums));
    }
}
