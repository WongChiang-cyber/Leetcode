package JZcodes;

import java.util.ArrayList;
import java.util.HashSet;

public class JZ68_lowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (p.val!=node.val && q.val!=node.val){
            if(p.val < node.val && q.val < node.val)
                node = node.left;
            else if(p.val > node.val && q.val > node.val)
                node = node.right;
            else
                return node;
        }
        return node;
    }
}
