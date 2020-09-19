package JZcodes;

public class JZ26_isSubStruct {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null)
            return false;
        boolean res = false;
        if(A.val == B.val)
            res = isSame(A,B);
        if(res)
            return true;
        else{
            return isSubStructure(A.left,B) || isSubStructure(A.right,B);
        }
    }

    private boolean isSame(TreeNode a,TreeNode b){
        if(b==null)
            return true;
        if(a!=null){
            if(a.val == b.val)
                return isSame(a.left,b.left) && isSame(a.right,b.right);
            else
                return false;
        }else
            return false;
    }
}
