package JZcodes;

import java.util.ArrayList;

public class JZ54_KthLargest {
    public int kthLargest(MyTreeNode root, int k) {
        if(root==null)
            return -1;
        ArrayList<Integer> list = new ArrayList<>();
        adddList(root,list);
        return list.get(k-1);
    }

    private void adddList(MyTreeNode node, ArrayList<Integer> list){
        if(node==null)
            return;
        int val = node.val;
        adddList(node.right, list);
        list.add(val);
        adddList(node.left,list);
    }
}
