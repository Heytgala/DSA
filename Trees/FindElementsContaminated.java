import java.util.HashSet;
import java.util.Set;

public class FindElementsContaminated {

    private Set<Integer> values; 

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public FindElementsContaminated(TreeNode root) {
        values = new HashSet<>();
        recoverytree(root, 0); 
    }

    private void recoverytree(TreeNode node, int value) {
        if (node == null) return;
        
        node.val = value;
        values.add(value);
        
        recoverytree(node.left, 2 * value + 1); 
        recoverytree(node.right, 2 * value + 2); 
    }

    public boolean find(int target) {
        return values.contains(target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        root.right.left = new TreeNode(-1);

        FindElementsContaminated findElements = new FindElementsContaminated(root);

        System.out.println("Results:");
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(2)); 
        System.out.println(findElements.find(3)); 
        System.out.println(findElements.find(7));
        System.out.println(findElements.find(5));
    }
}

