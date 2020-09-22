package JZcodes;

public class JZ68_lowestCommonAncestor2 {
    public MyTreeNode lowestCommonAncestor(MyTreeNode root, MyTreeNode p, MyTreeNode q) {
        MyTreeNode node = root;
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
