import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    public class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

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

    public List<List<Integer>> verticalOrder(TreeNode root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple current = q.poll();
            TreeNode node = current.node;
            int row = current.row;
            int col = current.col;

            if(!map.containsKey(row)){
                map.put(row, new TreeMap<>());
            }
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col, new PriorityQueue<>());
            }
            map.get(row).get(col).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left, row - 1, col + 1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> rowMap : map.values()){
            result.add(new LinkedList<>());
            for(PriorityQueue<Integer> pq : rowMap.values()){
                while(!pq.isEmpty()){
                    result.get(result.size() - 1).add(pq.poll());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        VerticalOrderTraversal v = new VerticalOrderTraversal();
        TreeNode root = v.new TreeNode(1);
        root.left = v.new TreeNode(2);
        root.right = v.new TreeNode(3);
        root.left.left = v.new TreeNode(4);
        root.left.left.right = v.new TreeNode(5);
        root.left.left.right.right = v.new TreeNode(6);
        root.right.right = v.new TreeNode(10);
        root.right.left = v.new TreeNode(9);
        List<List<Integer>> result = v.verticalOrder(root);
        System.out.println("Vertical Order Traversal: " + result);
    }
}
