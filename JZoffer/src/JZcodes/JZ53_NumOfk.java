package JZcodes;

public class JZ53_NumOfk {
    public static int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        int first = findFirstK(nums,0,nums.length-1,target);
        System.out.println("first = "+first);
        if(first==-1)
            return 0;
        int last = findLastK(nums,first,nums.length-1,target);
        System.out.println("last = "+last);
        return last - first + 1;
    }
    public static int findFirstK(int[] nums,int begin,int end,int k){
        if(begin>end)
            return -1;
        int mid = (begin+end)>>1;
        if(nums[mid]==k){
            if(mid==0 || nums[mid-1]!=k){
                //find the first k
                return mid;
            }else{
                return findFirstK(nums,begin,mid-1,k);
            }
        }else if(nums[mid]>k){
            return findFirstK(nums,begin,mid-1,k);
        }else{
            return findFirstK(nums,mid+1,end,k);
        }

    }
    public static int findLastK(int[] nums,int begin,int end,int k){
        if(begin>end)
            return -1;
        int mid = (begin+end)>>1;
        if(nums[mid]==k){
            if(mid==nums.length-1 || nums[mid+1]!=k){
                //find the first k
                return mid;
            }else{
                return findLastK(nums,mid+1,end,k);
            }
        }else if(nums[mid]>k){
            return findLastK(nums,begin,mid-1,k);
        }else{
            return findLastK(nums,mid+1,end,k);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        search(nums,2);
    }
}
