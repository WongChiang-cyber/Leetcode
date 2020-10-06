package LeetCode;

import java.util.ArrayList;

public class LC109_sortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<TreeNode> list = new ArrayList<>();
        ListNode node = head;
        if(node==null)
            return null;
        while(node!=null){
            list.add(new TreeNode(node.val));
            node = node.next;
        }
        return buildBST(list,0,list.size()-1);
    }

    private TreeNode buildBST(ArrayList<TreeNode> list,int start,int end){
        if(start==end){
            return list.get(start);
        }else if(start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode left = buildBST(list,start,mid-1);
        TreeNode right = buildBST(list,mid+1,end);
        list.get(mid).left = left;
        list.get(mid).right = right;
        return list.get(mid);
    }

    public static ListNode buildList(int[] args){
        ListNode head = new ListNode(args[0]);
        ListNode node = head;
        for (int i = 1; i < args.length; i++) {
            node.next = new ListNode(args[i]);
            node= node.next;
        }ListNode node0 = new ListNode(-10);
        return head;
    }
    public static void main(String[] args) {
        LC109_sortedListToBST t = new LC109_sortedListToBST();
        int[] nums = {-10,-3,0,5,9};
        ListNode list = buildList(nums);
        TreeNode root = t.sortedListToBST(list);
    }
}
