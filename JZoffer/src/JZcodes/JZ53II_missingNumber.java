package JZcodes;

public class JZ53II_missingNumber {
    public static int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        return findMissing(nums,start,end);
    }
    public static int findMissing(int[] nums,int start,int end){
        if(start>end)
            return nums.length;
        int mid = (start+end)>>1;
        if(nums[mid]==mid){
            //missing is between [mid+1,end]
            return findMissing(nums,mid+1,end);
        }else if(nums[mid]>mid){
            //missing is between [start,mid-1]
            if(mid==0)
                return 0;
            else if(nums[mid-1]==mid-1)
                return mid;
            else
                return findMissing(nums,start,mid-1);
        }else
            //impossible situation
            return nums.length;
    }

    public static void main(String[] args) {
        int[]nums = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(missingNumber(nums));
    }
}
