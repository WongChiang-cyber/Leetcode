package LeetCode;

import java.util.HashMap;

public class LC337_robIII {
    HashMap<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int if_rob = root.val;
        if(root.left!=null)
            if_rob += rob(root.left.left)+rob(root.left.right);
        if(root.right!=null)
            if_rob += rob(root.right.left)+rob(root.right.right);
        int not_rob = 0;
        not_rob += rob(root.left)+rob(root.right);
        int value =  Math.max(if_rob,not_rob);
        map.put(root,value);
        return value;
    }
}
