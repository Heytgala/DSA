import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTrees {
    public class Node{
        int data;
        Node left;
        Node right;
        public Node(int key){
            data = key;
            left=null;
            right=null;
        }
    }

    //POST ORDER TRAVERSAL
    public static void postorder(Node root, List<Integer> result){
        if(root==null){
            return;
        }
        postorder(root.left,result);
        postorder(root.right,result);
        result.add(root.data);
    }

    public List<Integer> postorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return result;
    }

    //INORDER TRAVERSAL
    public static void inorder(Node root, List<Integer> result){
        if(root==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.data);
        inorder(root.right,result);
    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }


    //PRE ORDER TRAVERSAL
    public static void preorder(Node root, List<Integer> result){
        if(root==null){
            return;
        }
        result.add(root.data);
        preorder(root.left,result);
        preorder(root.right,result);
    }

    public List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }

    //Iterative Preorder
    public List<Integer> IterativePreorder(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            result.add(root.data);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return result;
    }

    //Iterative Inorder
    public List<Integer> IterativeInorder(Node root){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
            while(current !=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.data);
            current = current.right;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTrees bt = new BinaryTrees();

        Node root = bt.new Node(10);

        root.left = bt.new Node(5);
        root.right = bt.new Node(15);
        root.right.left = bt.new Node(20);
        
        List<Integer> result = bt.preorderTraversal(root);
        System.out.print("Preorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        List<Integer> iterative_preorder_result = bt.IterativePreorder(root);
        System.out.print("Iterative Preorder Traversal: ");
        for (int val : iterative_preorder_result) {
            System.out.print(val + " ");
        }
        System.out.println();

        result = bt.postorderTraversal(root);
        System.out.print("Postorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        result = bt.inorderTraversal(root);
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();

        List<Integer> iterative_inorder_result = bt.IterativeInorder(root);
        System.out.print("Iterative Inorder Traversal: ");
        for (int val : iterative_inorder_result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
