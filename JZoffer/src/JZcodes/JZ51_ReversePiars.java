package JZcodes;

import java.util.Arrays;

public class JZ51_ReversePiars {
    public static int reversePairs(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int length = nums.length;
        int[] copy = Arrays.copyOf(nums,nums.length);
        int end = length-1;
        int count = countPairs(nums,copy,0,end);
        return count;
    }

    private static int countPairs(int[] nums,int[] copy,int start,int end){
        if(start==end)
            return 0;
        //length = real length minus 1
        int length = end-start;
        int count = 0;
        int left_start = start;
        int right_end = end;
        int left_end = start+length/2;
        int right_start = start+length/2+1;
        //System.out.println("s: "+left_start+" e: "+left_end+" s:"+right_start+" e:"+right_end);

        int count_left = countPairs(nums,copy,left_start,left_end);
        int count_right = countPairs(nums,copy,right_start,right_end);

        int i = left_end;
        int j = right_end;
        int copyIndex = right_end;
        while(i>=left_start && j>=right_start){
            if(nums[i]>nums[j]){
                count += j-right_start+1;
                copy[copyIndex] = nums[i];
                i--;
                copyIndex--;
            }else{
                copy[copyIndex] = nums[j];
                j--;
                copyIndex--;
            }
        }

        //deal with the nums that has not been put into copy array
        while(i>=left_start){
            copy[copyIndex] = nums[i];
            i--;
            copyIndex--;
        }
        while(j>=right_start){
            copy[copyIndex] = nums[j];
            j--;
            copyIndex--;
        }
        //System.out.println("after count: return "+count+"+"+count_left+"+"+count_right);
        for (int k = left_start; k <= right_end ; k++) {
            nums[k] = copy[k];
            //System.out.print(" "+nums[k]);
        }
        //System.out.println();

        return count+count_left+count_right;
    }

    public static void main(String[] args) {
        int[] nums = {3,1};
        System.out.println(reversePairs(nums));
    }
}
