package JZcodes;

public class JZ33_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length==0)
            return true;
        return find(postorder,postorder.length-1,0);
    }
    public boolean find(int[] postorder,int root,int start){
        if(start>=root)
            return true;
        int val = postorder[root];
        int i = start;
        while(i < root) {
            if(postorder[i]<val){
                i++;
            }else
                break;
        }
        int next_root = i-1;
        while(i<root){
            if(postorder[i++]<val)
                return false;
        }
        return find(postorder,next_root,start) && find(postorder,root-1,next_root+1);
    }

    public static void main(String[] args) {
        JZ33_verifyPostorder t = new JZ33_verifyPostorder();
        int[] a = {5, 2, -17, -11, 25};
        System.out.println(t.verifyPostorder(a));
    }
}
