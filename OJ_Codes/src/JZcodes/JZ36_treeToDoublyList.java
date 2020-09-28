package JZcodes;

public class JZ36_treeToDoublyList {
    public MyTreeNode treeToDoublyList(MyTreeNode root) {
        HeadAndTail res = find(root);
        if(res!=null)
            return res.head;
        else
            return null;
    }

    public HeadAndTail find(MyTreeNode node){
        if(node==null)
            return null;
        if(node.left == null && node.right == null){
            //find a leaf
            node.left = node;
            node.right = node;
            return new HeadAndTail(node, node);
        }
        MyTreeNode resHead=null,resTail = null;
        HeadAndTail leftList = null,rightList = null;
        leftList = find(node.left);
        rightList = find(node.right);
        if(leftList!=null && rightList!=null){
            //deal with left list
            leftList.tail.right = node;
            node.left = leftList.tail;
            //deal with right list
            rightList.head.left = node;
            node.right = rightList.head;
            //deal with head & tail
            leftList.head.left = rightList.tail;
            rightList.tail.right = leftList.head;
            //return
            return new HeadAndTail(leftList.head,rightList.tail);
        }else if(leftList != null){
            //deal with left list
            leftList.tail.right = node;
            leftList.head.left = node;
            node.right = leftList.head;
            node.left = leftList.tail;
            return new HeadAndTail(leftList.head,node);
        }else if(rightList!=null){
            rightList.head.left = node;
            rightList.tail.right = node;
            node.left = rightList.tail;
            node.right = rightList.head;
            return new HeadAndTail(node,rightList.tail);
        }
        return null;
    }

    class HeadAndTail{
        MyTreeNode head;
        MyTreeNode tail;

        public HeadAndTail(MyTreeNode head, MyTreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        MyTreeNode node = new MyTreeNode(1);
        JZ36_treeToDoublyList t = new JZ36_treeToDoublyList();
        System.out.println(t.treeToDoublyList(node).val);
    }

}

