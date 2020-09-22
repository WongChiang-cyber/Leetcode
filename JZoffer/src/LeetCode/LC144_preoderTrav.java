package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144_preoderTrav {
    //这里是迭代写法
    public List<Integer> preorderTraversal(MyTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            MyTreeNode node = stack.pop();
            res.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return res;
    }

    class Solution2 extends LC144_preoderTrav{
        //这里是递归写法
        @Override
        public List<Integer> preorderTraversal(MyTreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            trav(root,res);
            return res;
        }
        private void trav(MyTreeNode node, ArrayList<Integer> res){
            if(node!=null)
                res.add(node.val);
            else
                return;
            if(node.left!=null)
                trav(node.left,res);
            if(node.right!=null)
                trav(node.right,res);
        }
    }

    //莫里斯遍历 还没有掌握


}

