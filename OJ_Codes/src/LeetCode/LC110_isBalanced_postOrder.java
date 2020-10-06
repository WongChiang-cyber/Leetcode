package LeetCode;

public class LC110_isBalanced_postOrder {
    public boolean isBalanced(TreeNode root) {
        int res = check(root,1);
        return res != -1;
    }
    private int check(TreeNode node,int depth){
        if(node==null)
            return depth-1;
        if(node.left==null && node.right==null){
            return depth;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        leftDepth = check(node.left,depth+1);
        rightDepth = check(node.left,depth+1);
        System.out.println("leftDepth="+leftDepth);
        System.out.println("rightDepth="+rightDepth);
        if(leftDepth==-1 || rightDepth==-1)
            return -1;
        if(leftDepth-rightDepth>1 || rightDepth-leftDepth>1){
            return -1;
        }
        else
            return Math.max(leftDepth,rightDepth);
    }
}
