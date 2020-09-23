package JZcodes;

public class JZ25_MergeList_without_new_list {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        head.next = l1;
        ListNode preNode = head;
        if(l1==null) return l2;
        if(l2==null) return l1;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                ListNode temp = l2.next;
                preNode.next = l2;
                l2.next = l1;
                preNode = l2;
                l2 = temp;
            }else{
                l1=l1.next;
                preNode = preNode.next;
            }
        }
        if(l1==null){
            preNode.next = l2;
        }
        return head.next;
    }
}
