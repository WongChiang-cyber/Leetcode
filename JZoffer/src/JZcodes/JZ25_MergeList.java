package JZcodes;

public class JZ25_MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        if(l1==null) return l2;
        if(l2==null) return l1;
        while(l1!=null && l2!=null){
            node.next = new ListNode(Math.min(l1.val, l2.val));
            if(l1.val<l2.val)
                l1 = l1.next;
            else
                l2 = l2.next;
            node = node.next;
        }
        if(l1==null)
            node.next = l2;
        else
            node.next = l1;
        return head.next;
    }
}
