package JZcodes;
import java.util.ArrayList;
import java.util.List;
public class JZ34_pathSum {
    public List<List<Integer>> pathSum(MyTreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        find(root,sum,res,path,0);
        return res;
    }

    public void find(MyTreeNode node,int Sum,List<List<Integer>> res,List<Integer> path,int pathSum){
        if(node==null)
            return;
        //System.out.println("find"+node.val+" sum:"+pathSum);
        path.add(node.val);
        if(node.left==null && node.right==null){
            //find the leaf
            int sum = pathSum+node.val;
            if(sum==Sum){
                List<Integer> newResult = new ArrayList<>(path);
                res.add(newResult);
            }
            path.remove(path.size()-1);
            return;
        }else{
            if(node.left!=null){
                find(node.left,Sum,res,path,pathSum+node.val);
            }
            if(node.right!=null){
                find(node.right,Sum,res,path,pathSum+node.val);
            }
            path.remove(path.size()-1);
        }
    }
}
