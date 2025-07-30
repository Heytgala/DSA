import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
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

    public void addLeftBoundary(TreeNode node, List<Integer> result){
        TreeNode current = node.left;
        while(current !=null){
            if(current.left != null || current.right !=null){
                result.add(current.val);
            }
            if(current.left !=null){
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    public void addLeaves(TreeNode node, List<Integer> result){
        if(node == null) return;
        if(node.left == null && node.right == null){
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    public void addRightBoundary(TreeNode node,List<Integer> result){
        List<Integer> temp = new ArrayList<>();
        TreeNode current = node;
        while(current!= null){
            if(current.left!=null || current.right!=null){
                temp.add(current.val);
            }
            if(current.right!= null){
                current = current.right;
            } else {
                current = current.left;
            }
            int i;
            for(i = temp.size() - 1; i >= 0; i--){
                result.add(temp.get(i));
            }
            temp.clear();
        }
    }

    public List<Integer> boundaryTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        result.add(root.val);
        addLeftBoundary(root,result);
        addLeaves(root,result);
        addRightBoundary(root.right,result);
        return result;
    }

    public static void main(String[] args){
        BoundaryTraversal bt = new BoundaryTraversal();
        TreeNode root = bt.new TreeNode(1);
        root.left = bt.new TreeNode(2);
        root.right = bt.new TreeNode(3);
        root.left.left = bt.new TreeNode(4);
        root.left.right = bt.new TreeNode(5);
        root.right.right = bt.new TreeNode(6);
        
        System.out.println("Boundary Traversal: " + bt.boundaryTraversal(root));
    }
}
