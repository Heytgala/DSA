public class ChildrenSumProperty {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void childrensumtree(TreeNode root) {
        if(root == null) {
            return;
        }
        int child=0;
        if(root.left!=null){
            child += root.left.val;
        }
        if(root.right!=null){
            child += root.right.val;
        }

        if(child>=root.val){
            root.val = child;
        }
        else{
            if(root.left != null){
                root.left.val = root.val;
            }
            else if(root.right != null){
                root.right.val = root.val;
            }
        }

        childrensumtree(root.left);
        childrensumtree(root.right);

        int total = 0;
        if(root.left != null){
            total += root.left.val;
        }
        if(root.right != null){
            total += root.right.val;
        }
        if(root.left != null || root.right != null) {
            root.val = total;
        }
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    public static void main(String[] args){
        ChildrenSumProperty csp = new ChildrenSumProperty();
        TreeNode root = csp.new TreeNode(40);
        root.left = csp.new TreeNode(10);
        root.right = csp.new TreeNode(20);
        root.left.left = csp.new TreeNode(2);
        root.left.right = csp.new TreeNode(5);
        root.right.left = csp.new TreeNode(30);
        root.right.right = csp.new TreeNode(40);

        System.out.print("Binary Tree before modification (inorder): ");
        csp.inorderTraversal(root);
        System.out.println();

        csp.childrensumtree(root);

        System.out.print("Binary Tree after modification (inorder): ");
        csp.inorderTraversal(root); 
        System.out.println();

    }
}
