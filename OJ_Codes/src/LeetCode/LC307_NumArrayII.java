package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
/**
* @Description: leetcode 307 快速查找下标从l到r的数组和
 * 方法1：顺序查找计算 build:O(1) sum：O(n^2) update O(1) 空间复杂度；O(n)
 * 方法2：保存前缀和，计算两前缀和差值 build:O(n) sum：O(1) update:O(n^2) 空间复杂度O(n)
 * 方法3：线段树/区间树 build:O(n) sum：O(log n)？ update:O(log n) 空间复杂度O(n)
 * 参考题解：https://www.bilibili.com/video/BV1cb411t7AM?t=869
* @Param:
* @return:
* @Author: WongChiang
* @Date: 2020/10/22
*/
public class LC307_NumArrayII {
    int[] tree;
    int n;
    int res;
    public LC307_NumArrayII(int[] nums) {
        if(nums==null)
            return;
        n = nums.length;
        double log = Math.log(nums.length)/Math.log(2);
        int depth = (int)Math.ceil(log)+1;
        int length = (int) Math.pow(2,depth)-1;
        tree = new int[length];
        buildTree(nums,tree,0,0,nums.length-1);
    }
    private void buildTree(int[] nums,int[] tree,int node,int start,int end){
        if(start==end){
            tree[node] = nums[start];
            return;
        }
        int mid = (start+end)/2;
        int left_node = node*2+1;
        int right_node = node*2+2;
        buildTree(nums,tree,left_node,start,mid);
        buildTree(nums,tree,right_node,mid+1,end);
        tree[node] = tree[left_node]+tree[right_node];
    }

    public void update(int i, int val) {
        if(tree == null)
            return;
        update(tree,0,n-1,0,i,val);
    }
    private void update(int[] tree,int start,int end,int node,int tar,int val){
        if(start==end) {
            tree[node] = val;
            return;
        }
        int mid = (start+end)/2;
        int left_node = node*2+1;
        int right_node = node*2+2;
        if(tar>=start && tar<=mid){
            update(tree,start,mid,left_node,tar,val);
        }else{
            update(tree,mid+1,end,right_node,tar,val);
        }
        tree[node] = tree[left_node]+tree[right_node];
    }

    public int sumRange(int i, int j) {
        if(tree==null)
            return 0;
        res = 0;
        sum(tree,0,n-1,0,i,j);
        return res;
    }
    private void sum(int[] tree,int start,int end,int node,int L,int R){
        System.out.println("start="+start+" end="+end+" node="+node+"res="+res);
        int mid = (start+end)/2;
        int left_node = node*2+1;
        int right_node = node*2+2;
        if(L==start && R==end){
            res += tree[node];
            return;
        }
        if(R<=mid){
            sum(tree,start,mid,left_node,L,R);
        }else if(L>=mid+1){
            sum(tree,mid+1,end,right_node,L,R);
        }else{
            sum(tree,start,mid,left_node,L,mid);
            sum(tree,mid+1,end,right_node,mid+1,R);
        }
    }

    /*public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,11};
        LC307_NumArrayII t = new LC307_NumArrayII(nums);
        System.out.println(Arrays.toString(t.tree));
        t.update(3,8);
        System.out.println(Arrays.toString(t.tree));
        System.out.println(t.sumRange(1,4));
    }*/
}

