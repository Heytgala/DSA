import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeConstruct {
    private int preidx = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return Helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode Helper(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preidx++];
        TreeNode root = new TreeNode(rootVal);

        int inorderidx = inorderMap.get(rootVal);

        root.left = Helper(preorder, left, inorderidx - 1);
        root.right = Helper(preorder, inorderidx + 1, right);

        return root;
    }
    
    public List<String> levelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add("null");
            }
        }
        while (result.get(result.size() - 1).equals("null")) {
            result.remove(result.size() - 1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTreeConstruct treeBuilder = new BinaryTreeConstruct();

        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();

        int[] preorder = new int[n];
        int[] inorder = new int[n];

        System.out.print("Enter preorder traversal (space-separated): ");
        for (int i = 0; i < n; i++) {
            preorder[i] = scanner.nextInt();
        }

        System.out.print("Enter inorder traversal (space-separated): ");
        for (int i = 0; i < n; i++) {
            inorder[i] = scanner.nextInt();
        }
        TreeNode root = treeBuilder.buildTree(preorder, inorder);
        System.out.println("Level-Order Output: " + treeBuilder.levelOrder(root));
        scanner.close();
    }
}
