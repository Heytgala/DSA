public class BT_Heap_Not {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public boolean isCBT(TreeNode root, int i, int nodecount){
        if(root==null){
            return true;
        }
        if(i>nodecount){
            return false;
        }
        else{
            boolean left = isCBT(root,((2*i)+1),nodecount);
            boolean right = isCBT(root,((2*i)+2),nodecount);
            return left && right;
        }
    }

    public boolean isMaxOrder(TreeNode root){
        if(root.left==null && root.right==null) return true;
        if(root.right==null){
            return root.val > root.left.val;
        }
        else{
            return root.val > root.left.val && root.val > root.right.val && isMaxOrder(root.left) && isMaxOrder(root.right);
        }
    }

    public int countNode(TreeNode root){
        if(root == null) return 0;
        int result = 1 + countNode(root.left) + countNode(root.right);
        return result;
    }

    public boolean Heap(TreeNode root)
    {
        int index=0;
        int nodecount = countNode(root);
        if(isCBT(root,index,nodecount) && isMaxOrder(root)) return true;
        else return false;
    }
    public static void main(String[] args) {
        BT_Heap_Not bth = new BT_Heap_Not();
        TreeNode root = bth.new TreeNode(10);
        root.left = bth.new TreeNode(20);
        root.right = bth.new TreeNode(30);
        root.left.left = bth.new TreeNode(40);
        root.left.right = bth.new TreeNode(60);

        boolean result = bth.Heap(root);
        System.err.println("The given binary tree can be considered as heap:" + result);


    }
}
