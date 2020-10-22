package LeetCode;
/**
* @Description: 非递归写法 来源自leetcode官方题解
* @Param:
* @return:
* @Author: LeetCode
* @Date: 2020/10/22
*/
public class LC307_NumArray {
    int[] tree;
    int n;
    /**
    * @Description: 建立线段树
    * @Param: [nums]
    * @return:
    * @Author: WongChiang
    * @Date: 2020/10/22
    */
    public LC307_NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    /**
    * @Description: 更新tree[pos]为val
    * @Param: [pos, val]
    * @return: void
    * @Author: WongChiang
    * @Date: 2020/10/22
    */
    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    /** 
    * @Description: 查询从[l,r]的区间的加和
    * @Param: [l, r] 
    * @return: int 
    * @Author: WongChiang
    * @Date: 2020/10/22 
    */ 
    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        LC307_NumArray t = new LC307_NumArray(nums);
        System.out.println(t.sumRange(1,4));
    }

}
