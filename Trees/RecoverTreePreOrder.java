import java.util.*;

class TreeNode {
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

public class RecoverTreePreOrder {

    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int i = 0;

        while (i < traversal.length()) {
            int depth = 0;

            // Calculate the depth by counting dashes
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Get the node value
            int value = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(value);

            // Adjust the stack to match the correct depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // If the stack is not empty, attach the node as a child
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        RecoverTreePreOrder solution = new RecoverTreePreOrder();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the preorder traversal string: ");
        String traversal = scanner.nextLine();

        TreeNode root = solution.recoverFromPreorder(traversal);

        System.out.println("Level-order traversal of the recovered tree (including nulls for missing nodes):");
        printLevelOrder(root);
        scanner.close();
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        while (result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }
}
