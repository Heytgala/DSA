import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostTraversal {
    class Node {
        int data;
        Node left, right;

        public Node(int key) {
            data = key;
            left = right = null;
        }
    }

    static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static List<List<Integer>> preinPostTraversal(Node root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        if (root == null) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(pre);
            result.add(in);
            result.add(post);
            return result;
        }

        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.state == 1) {
                pre.add(top.node.data);
                top.state++;
                if (top.node.left != null) {
                    stack.push(new Pair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                in.add(top.node.data);
                top.state++;
                if (top.node.right != null) {
                    stack.push(new Pair(top.node.right, 1));
                }
            } else {
                post.add(top.node.data);
                stack.pop();
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }

    public static void main(String[] args) {
        PreInPostTraversal tree = new PreInPostTraversal();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.left.left = tree.new Node(5);
        root.left.right = tree.new Node(6);
        root.right.right = tree.new Node(7);
        root.right.right.right = tree.new Node(8);
        
        List<List<Integer>> result = tree.preinPostTraversal(root);
        System.out.println("Preorder: " + result.get(0));
        System.out.println("Inorder: " + result.get(1));
        System.out.println("Postorder: " + result.get(2));
    }
}
