package WeBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main03 {

    public static int find(int[] nums,int m){
        int len = nums.length;
        while (next(nums)!=null){

        }
        return 0;
    }

    public static int[] next(int[] nums){
        //找到升序数组
        int i = nums.length-1;
        for (; i >=1 ; i--) {
            if(nums[i]<=nums[i-1])
                continue;
            else
                break;
        }
        //完全升序
        if(i==0)
            return null;
        //交换
        int temp = nums[nums.length-1];
        nums[nums.length-1] = nums[i-1];
        nums[i-1] = temp;
        //重排升序数组
        int[] sort = Arrays.copyOfRange(nums,i,nums.length);
        Arrays.sort(sort);
        for (int j = 0; j < sort.length; j++) {
            nums[j+i] = sort[j];
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int m = sc.nextInt();
        int[] nums = new int[str.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = str.charAt(i)-'0';
        }
        System.out.println(find(nums,m));;
    }
}
