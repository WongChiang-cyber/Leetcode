package JZcodes;

public class JZ55_isBalanced {
    public boolean isBalanced(MyTreeNode root) {
        if(root==null)
            return true;
        int maxDepth = find(root,0);
        if(maxDepth==-1)
            return false;
        else
            return true;
    }

    private int find(MyTreeNode node, int depth){
        if(node==null)
            return depth;
        int nowDepth = depth+1;
        int leftDepth = nowDepth;
        int rightDepth = nowDepth;
        if(node.left!=null){
            leftDepth = find(node.left,nowDepth);
        }
        if(node.right!=null){
            rightDepth = find(node.right,nowDepth);
        }
        if(rightDepth == -1 || leftDepth == -1 || rightDepth-leftDepth>1 || leftDepth-rightDepth>1)
            return -1;
        else
            return Math.max(leftDepth, rightDepth);
    }
}
