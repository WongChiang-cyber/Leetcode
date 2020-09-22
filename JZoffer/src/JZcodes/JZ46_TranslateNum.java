package JZcodes;

public class JZ46_TranslateNum {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        treeNode root = new treeNode(-1,'#',str);
        createTree(root);
        Integer sum = 0;
        sum = counterLeaf(root,sum);
        return sum;
    }

    private void createTree(treeNode node){
        if(node==null || node.storeStr==null)
            return;
        if(node.storeStr.length()>=1){
            String leftStr = node.storeStr.substring(0,1);
            int offset = Integer.parseInt(leftStr);
            char val = (char) ('a'+offset);
            String str = node.storeStr.substring(1,node.storeStr.length());
            node.left = new treeNode(offset,val,str);
            createTree(node.left);
        }
        if(node.storeStr.length()>=2){
            String rightStr = node.storeStr.substring(0,2);
            int offset = Integer.parseInt(rightStr);
            if (offset <= 25 && offset>=10) {
                char val = (char) ('a'+offset);
                String str = node.storeStr.substring(2,node.storeStr.length());
                node.right = new treeNode(offset,val,str);
                createTree(node.right);
            }
        }
    }

    private int counterLeaf(treeNode node, Integer sum){
        if(node==null)
            return 0;
        int l = counterLeaf(node.left,sum);
        int r = counterLeaf(node.right,sum);
        if(node.left==null&&node.right==null){
            //System.out.println("leaf"+node);
            return 1;
        } else{
            return l+r;
        }
    }

    public static void main(String[] args) {
        JZ46_TranslateNum t = new JZ46_TranslateNum();
        System.out.println(t.translateNum(12258));
    }

    class treeNode {
        int offset;
        char val;
        String storeStr;
        treeNode left;
        treeNode right;
        public treeNode(int offset, char val, String storeStr) {
            this.offset = offset;
            this.val = val;
            this.storeStr = storeStr;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "offset=" + offset +
                    ", val=" + val +
                    ", storeStr='" + storeStr + '\'' +
                    '}';
        }
    }
}

