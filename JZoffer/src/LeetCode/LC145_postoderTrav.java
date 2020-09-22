package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC145_postoderTrav {
    //这里是迭代写法
    public List<Integer> postoderTraversal(MyTreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        if(root==null) return list;
        stack.push(root);
        while(!stack.isEmpty()){
            MyTreeNode node = stack.pop();
            list.addFirst(node.val);
            if(node.left!=null) stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
        }
        return list;
    }

    class Solution extends LC145_postoderTrav {
        //这里是递归写法
        @Override
        public List<Integer> postoderTraversal(MyTreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            trav(root,res);
            return res;
        }
        private void trav(MyTreeNode node, ArrayList<Integer> res){
            if(node==null)
               return;
            if(node.left!=null)
                trav(node.left,res);
            if(node.right!=null)
                trav(node.right,res);
            res.add(node.val);
        }
    }


}

