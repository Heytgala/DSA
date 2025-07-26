import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> levelorder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for(int i=0;i<size;i++){
                if(queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                sublist.add(queue.poll().val);
            }
            result.add(sublist);
        }
        return result;
    }

    public static void main(String[] args) {
        LevelOrderTraversal lot = new LevelOrderTraversal();
        TreeNode root = lot.new TreeNode(1);
        root.left = lot.new TreeNode(2);
        root.right = lot.new TreeNode(3);
        root.left.left = lot.new TreeNode(4);
        root.left.left.left = lot.new TreeNode(5);
        root.left.left.right = lot.new TreeNode(6);

        List<List<Integer>> result = lot.levelorder(root);
        for(List<Integer> level : result) {
            for(int val : level) {
                System.out.print(val + " ");    
            }
            System.out.println();  
        }
    }
}
