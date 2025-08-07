import java.util.*;

public class BinaryTreeConstruct_II {
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

    private int postidx = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postidx = postorder.length - 1;
        return TreeBuildHelper(postorder, 0, inorder.length - 1);
    }

    public TreeNode TreeBuildHelper(int[] postorder, int left,int right){
        if(left>right) return null;
        int root = postorder[postidx--];
        TreeNode node = new TreeNode(root);
        int idx = inorderMap.get(root);
        node.right = TreeBuildHelper(postorder,idx+1,right);
        node.left = TreeBuildHelper(postorder,left,idx-1);
        return node;
    }

    public List<String> levelOrder(TreeNode root){
        List<String> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add("null");
            }
            while (result.get(result.size() - 1).equals("null")) {
                result.remove(result.size() - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeConstruct_II tree = new BinaryTreeConstruct_II();
        System.out.println("Enter the total no of nodes:");     
        int n = sc.nextInt();
        int[] postorder = new int[n];
        int[] inorder = new int[n];
        System.out.println("Enter the postorder traversal:");
        for(int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt(); 
        }
        System.out.println("Enter the inorder traversal:");
        for(int i = 0; i < n; i++) {    
            inorder[i] = sc.nextInt(); 
        }   

        TreeNode root = tree.buildTree(postorder, inorder);
        System.out.println("Level order traversal of the constructed tree:");
        System.out.println(tree.levelOrder(root));
        sc.close();
    }
}
