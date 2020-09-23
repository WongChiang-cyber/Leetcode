package JZcodes;

public class JZ55_maxDepth {
    public int maxDepth(MyTreeNode root) {
        if(root==null)
            return 0;
        int depth;
        depth = find(root,0);
        return depth;
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
        return Math.max(leftDepth, rightDepth);
    }
}
