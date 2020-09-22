package JZcodes;

import java.util.ArrayList;
import java.util.HashSet;

public class JZ68_lowestCommonAncestor {
    public MyTreeNode lowestCommonAncestor(MyTreeNode root, MyTreeNode p, MyTreeNode q) {
        ArrayList<MyTreeNode> l1 = new ArrayList<>();
        HashSet<MyTreeNode> set2 = new HashSet<>();
        MyTreeNode node = root;
        while(node!=p){
            l1.add(node);
            if(p.val<node.val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        l1.add(node);
        node = root;
        while(node!=q){
            set2.add(node);
            if(q.val<node.val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        set2.add(node);
        for (int i = l1.size()-1; i >= 0; i--) {
            if(set2.contains(l1.get(i)))
                return l1.get(i);
        }
        return null;
    }
}
