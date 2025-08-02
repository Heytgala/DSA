import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
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

    public class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node, int col){
            this.node = node;
            this.col = col;
        }
    }

    public List<Integer> topView(TreeNode root){
        List<Integer> result = new LinkedList<>();
        if(root== null) return result;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.add(new Tuple(root,0));
        while(!q.isEmpty()){
            Tuple current = q.remove();
            TreeNode node = current.node;
            int col = current.col;
            if(!map.containsKey(col)){
                map.put(col, node.val);
            }
            if(node.left != null){
                q.add(new Tuple(node.left, col - 1));
            }
            if(node.right != null){
                q.add(new Tuple(node.right, col + 1));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    } 

    public static void main(String[] args){
        TopView tv = new TopView();
        TreeNode root = tv.new TreeNode(1);
        root.left = tv.new TreeNode(2);
        root.right = tv.new TreeNode(3);
        root.left.left = tv.new TreeNode(4);
        root.left.right = tv.new TreeNode(5);
        root.right.right = tv.new TreeNode(7);
        root.left.right.left = tv.new TreeNode(6);
        System.out.println("Top View of the tree: " + tv.topView(root));
    }

}
