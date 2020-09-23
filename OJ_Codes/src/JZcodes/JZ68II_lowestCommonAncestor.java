package JZcodes;

import java.util.HashSet;
import java.util.Stack;

public class JZ68II_lowestCommonAncestor {
    public MyTreeNode lowestCommonAncestor(MyTreeNode root, MyTreeNode p, MyTreeNode q) {
        Stack<MyTreeNode> stack = new Stack<>();
        boolean r1 = find(root,p,stack);
        HashSet<MyTreeNode> set = new HashSet<>();
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        boolean r2 = find(root,q,stack);
        while(!stack.isEmpty()){
            MyTreeNode res = stack.pop();
            if(set.contains(res))
                return res;
        }
        return null;
    }

    private boolean find(MyTreeNode node, MyTreeNode t, Stack<MyTreeNode> stack){
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
