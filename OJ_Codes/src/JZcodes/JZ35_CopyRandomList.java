package JZcodes;

public class JZ35_CopyRandomList {

    public LinkedNode copyRandomList(LinkedNode head) {
        if(head==null)
            return null;
        LinkedNode virtual_head = new LinkedNode(-1);
        virtual_head.next = head;
        LinkedNode linkedNode = head;
        //copy new linkedNode in list
        while(linkedNode !=null){
            LinkedNode new_Linked_node = new LinkedNode(linkedNode.val);
            new_Linked_node.next = linkedNode.next;
            new_Linked_node.random = linkedNode.random;
            linkedNode.next = new_Linked_node;
            linkedNode = linkedNode.next.next;
        }
        //move the random
        linkedNode = head.next;
        while(linkedNode.next!=null){
            if(linkedNode.random!=null)
                linkedNode.random = linkedNode.random.next;
            linkedNode = linkedNode.next.next;
        }
        if(linkedNode.random!=null)
            linkedNode.random = linkedNode.random.next;
        //split from origin list
        linkedNode = virtual_head;
        LinkedNode next_Linked_node = linkedNode.next.next;
        while (next_Linked_node.next!=null){
            linkedNode.next.next = next_Linked_node.next;
            linkedNode.next = next_Linked_node;
            linkedNode = linkedNode.next;
            next_Linked_node = next_Linked_node.next.next;
        }
        linkedNode.next.next = next_Linked_node.next;
        linkedNode.next = next_Linked_node;
        //return
        return virtual_head.next;
    }

    public static void main(String[] args) {

        LinkedNode linkedNode7 = new LinkedNode(7);
        LinkedNode linkedNode13 = new LinkedNode(13);
        LinkedNode linkedNode11 = new LinkedNode(11);
        LinkedNode linkedNode10 = new LinkedNode(10);
        LinkedNode linkedNode1 = new LinkedNode(1);

        linkedNode7.next = linkedNode13;
        linkedNode13.next = linkedNode11;
        linkedNode11.next = linkedNode10;
        linkedNode10.next = linkedNode1;

        linkedNode13.random = linkedNode7;
        linkedNode11.random = linkedNode1;
        linkedNode10.random = linkedNode11;
        linkedNode1.random = linkedNode7;

        JZ35_CopyRandomList t = new JZ35_CopyRandomList();
        LinkedNode linkedNode0 = new LinkedNode(0);
        LinkedNode copy = t.copyRandomList(linkedNode7);

    }
}
class LinkedNode {
    int val;
    LinkedNode next;
    LinkedNode random;

    public LinkedNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
