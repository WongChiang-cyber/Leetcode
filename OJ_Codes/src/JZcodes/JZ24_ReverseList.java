package JZcodes;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class JZ24_ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        return reverse(head,head.next);
    }

    private ListNode reverse(ListNode pre,ListNode cur){
        if(cur==null || pre==null){
            return pre;
        }
        if(cur.next==null){
            cur.next = pre;
            pre.next = null;
            ListNode head = cur;
            return head;
        }else{
            ListNode head = reverse(pre.next,cur.next);
            cur.next = pre;
            pre.next = null;
            //System.out.print(head.val);
            //System.out.println(" "+cur.val);
            return head;
        }
    }
}
