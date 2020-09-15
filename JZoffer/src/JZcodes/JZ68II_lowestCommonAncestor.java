package JZcodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class JZ68II_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        boolean r1 = find(root,p,stack);
        HashSet<TreeNode> set = new HashSet<>();
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        boolean r2 = find(root,q,stack);
        while(!stack.isEmpty()){
            TreeNode res = stack.pop();
            if(set.contains(res))
                return res;
        }
        return null;
    }

    private boolean find(TreeNode node, TreeNode t, Stack<TreeNode> stack){
        if(node==null||t==null)
            return false;
        stack.push(node);
        if(node.val == t.val){
            return true;
        }
        if(!find(node.left, t, stack) && !find(node.right, t, stack)){
            stack.pop();
            return false;
        }else
            return true;
    }
}
