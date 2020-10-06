package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LC919_CBTInserter {

    private TreeNode root;
    private ArrayList<TreeNode> list;

    public LC919_CBTInserter(TreeNode root) {
        list = new ArrayList<>();
        if(root==null){
            return;
        }
        this.root = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public int insert(int v) {
        if(list.size()==0){
            root = new TreeNode(v);
            list.add(root);
            return 0;
        }
        int index = (list.size()-1)/2;
        TreeNode parent = list.get(index);
        if(parent.left==null){
            parent.left = new TreeNode(v);
            list.add(parent.left);
            return parent.val;
        }else if(parent.right==null){
            parent.right = new TreeNode(v);
            list.add(parent.right);
            return parent.val;
        }
        return 0;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        LC919_CBTInserter t = new LC919_CBTInserter(root);
        t.insert(2);
    }
}
