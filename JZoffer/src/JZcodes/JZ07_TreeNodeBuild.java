package JZcodes;

public class JZ07_TreeNodeBuild {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = build(preorder,0,inorder,0,preorder.length);
        return root;
    }

    public TreeNode build(int[] preorder,int pre_start,int[] inorder,int in_start,int length){

        if(length <= 0)
            return null;
        TreeNode root = new TreeNode(preorder[pre_start]);
        int root_index = 0;
        for (int i = in_start; i < in_start+length ; i++) {
            if(inorder[i] == root.val) {
                root_index = i;
                break;
            }
        }
        int left_length = root_index - in_start;
        int right_length = length - left_length - 1;
        int left_pre_start = pre_start+1;
        int right_pre_start = left_pre_start + left_length;
        int left_in_start = in_start;
        int right_in_start = root_index +1;

        root.left = build(preorder,left_pre_start,inorder,left_in_start,left_length);

        root.right = build(preorder,right_pre_start,inorder,right_in_start,right_length);

        return root;
    }

    public static void main(String[] args) {
        JZ07_TreeNodeBuild t = new JZ07_TreeNodeBuild();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        t.buildTree(pre,in);
    }
}
