package JZcodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JZ32_III_levelOrder {
    public List<List<Integer>> levelOrder(MyTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        LinkedList<MyTreeNode> list = new LinkedList<>();
        list.add(root);
        boolean reverse = false;
        while(!list.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int size = list.size();
            if(reverse){
                for (int i = 0; i < size; i++) {
                    MyTreeNode node = list.getLast();
                    list.removeLast();
                    level.add(node.val);
                    if(node.right!=null)
                        list.addFirst(node.right);
                    if(node.left!=null)
                        list.addFirst(node.left);
                }
            }else{
                for (int i = 0; i < size; i++) {
                    MyTreeNode node = list.getFirst();
                    list.removeFirst();
                    level.add(node.val);
                    if(node.left!=null)
                        list.add(node.left);
                    if(node.right!=null)
                        list.add(node.right);
                }
            }
            reverse = !reverse;
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        MyTreeNode root = new MyTreeNode(3);
        root.left = new MyTreeNode(9);
        root.right = new MyTreeNode(20);
        root.right.left = new MyTreeNode(15);
        root.right.right = new MyTreeNode(7);
        JZ32_III_levelOrder t = new JZ32_III_levelOrder();
        List<List<Integer>> res = t.levelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).toString());
        }
    }
}
