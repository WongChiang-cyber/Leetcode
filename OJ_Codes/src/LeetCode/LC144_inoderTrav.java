package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144_inoderTrav {
    //这里是迭代写法
    public List<Integer> inorderTraversal(MyTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<MyTreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    class Solution extends LC144_inoderTrav{
        //这里是递归写法
        @Override
        public List<Integer> inorderTraversal(MyTreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            trav(root,res);
            return res;
        }
        private void trav(MyTreeNode node, ArrayList<Integer> res){
            if(node==null)
               return;
            if(node.left!=null)
                trav(node.left,res);
            res.add(node.val);
            if(node.right!=null)
                trav(node.right,res);
        }
    }


}

