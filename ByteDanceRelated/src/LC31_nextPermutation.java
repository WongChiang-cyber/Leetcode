import java.util.Arrays;

public class LC31_nextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums==null || nums.length==0)
            return;
        int i = nums.length-1;
        for (; i >= 1 ; i--) {
            if(nums[i]>nums[i-1])
                break;
        }
        if(i==0){
            Arrays.sort(nums);
            return;
        }
        Arrays.sort(nums,i,nums.length);
        for (int j = i; j < nums.length; j++) {
            if(nums[j]>nums[i-1]){
                int temp = nums[i-1];
                nums[i-1] = nums[j];
                nums[j] = temp;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {};
        LC31_nextPermutation t = new LC31_nextPermutation();
        t.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
