package JZcodes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JZ32_I_levelOrder {
    public int[] levelOrder(MyTreeNode root) {
        Queue<MyTreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null)
            return new int[]{};
        queue.add(root);
        list.add(root.val);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.left!=null){
                queue.add(root.left);
                list.add(root.left.val);
            }
            if(root.right!=null) {
                queue.add(root.right);
                list.add(root.right.val);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
