package WeBank;

import java.util.Arrays;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println(nums[nums.length-1]);
    }
}
