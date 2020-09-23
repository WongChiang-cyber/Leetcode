package JZcodes;

public class JZ52_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lengthA=0,lengthB=0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA!=null){
            nodeA=nodeA.next;
            lengthA++;
        }
        while(nodeB!=null){
            nodeB = nodeB.next;
            lengthB++;
        }
        int distance = lengthA>lengthB?lengthA-lengthB:lengthB-lengthA;
        if(lengthA>=lengthB){
            nodeA = headA;
            nodeB = headB;
            for (int i = 0; i < distance; i++) {
                nodeA = nodeA.next;
            }
        }else{
            nodeA = headA;
            nodeB = headB;
            for (int i = 0; i < distance; i++) {
                nodeB = nodeB.next;
            }
        }
        while(nodeA!=nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
}
