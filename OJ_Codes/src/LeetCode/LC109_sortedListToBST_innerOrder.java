package LeetCode;

import java.util.ArrayList;

public class LC109_sortedListToBST_innerOrder {

    ListNode globalHead;

    private int countLength(ListNode head){
        ListNode node = head;
        int res = 0;
        while(head!=null){
            head =head.next;
            res++;
        }
        return res;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        globalHead = head;
        return buildBST(0,countLength(head)-1);
    }

    private TreeNode buildBST(int start,int end){
        if(start==end){
            TreeNode node = new TreeNode(globalHead.val);
            //System.out.println(globalHead.val);
            globalHead = globalHead.next;
            return node;
        }else if(start>end)
            return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode();
        root.left = buildBST(start, mid-1);
        root.val = globalHead.val;
        //System.out.println(globalHead.val);
        globalHead = globalHead.next;
        root.right = buildBST(mid+1,end);
        return root;
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
        LC109_sortedListToBST_innerOrder t = new LC109_sortedListToBST_innerOrder();
        int[] nums = {-10,-3,0,5,9};
        ListNode list = buildList(nums);
        TreeNode root = t.sortedListToBST(list);
    }
}
