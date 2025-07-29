public class MaxPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxPathfinder(TreeNode root,int[] maxi){
        if(root==null) return 0;
        int left = Math.max(0,maxPathfinder(root.left,maxi));
        int right = Math.max(0,maxPathfinder(root.right,maxi));
        maxi[0]=Math.max(maxi[0], left+right+root.val);
        return root.val + Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        int[] d = new int[1];
        d[0]=Integer.MIN_VALUE;
        maxPathfinder(root,d);
        return d[0];
    }
    
    public static void main(String[] args) {
        MaxPathSum mp = new MaxPathSum();
        TreeNode root = mp.new TreeNode(-10);

        root.left = mp.new TreeNode(9);
        root.right = mp.new TreeNode(20);
        root.right.left = mp.new TreeNode(15);
        root.right.right = mp.new TreeNode(7);
        //TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Max Path Sum: " + mp.maxPathSum(root));
    }
}
