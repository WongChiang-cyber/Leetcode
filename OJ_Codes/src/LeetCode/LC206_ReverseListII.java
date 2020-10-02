package LeetCode;

class LC206_ReverseListII {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        head.next = null;
        return pre;
    }
}