import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinBurnTime {
    public class TreeNode {
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

    public void parentTrack(TreeNode root, Map<TreeNode, TreeNode> parentMap, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode current = q.poll();
            if(current.left != null) {
                parentMap.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right != null) {
                parentMap.put(current.right,current);
                q.offer(current.right);
            }
        }
    }
    public int minBurnTime(TreeNode root, TreeNode target) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentTrack(root, parentMap, target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int totalTime = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean isBurning = false;
            for(int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left) == null) {
                    q.offer(current.left);
                    visited.put(current.left, true);
                    isBurning = true;   
                }
                if(current.right != null && visited.get(current.right) == null) {
                    q.offer(current.right);
                    visited.put(current.right, true);
                    isBurning = true;   
                }
                if(parentMap.get(current) != null && visited.get(parentMap.get(current)) == null) {
                    q.offer(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                    isBurning = true;
                }
            }
            if(isBurning) {
                totalTime++;
            }
        }
        return totalTime;
    }
    public static void main(String[] args) {

        MinBurnTime minBurnTime = new MinBurnTime();
        TreeNode root = minBurnTime.new TreeNode(1);
        root.left = minBurnTime.new TreeNode(2);
        root.right = minBurnTime.new TreeNode(3);
        root.left.left = minBurnTime.new TreeNode(4);
        root.left.right = minBurnTime.new TreeNode(5);
        root.right.left = minBurnTime.new TreeNode(6);
        root.right.right = minBurnTime.new TreeNode(7);

        TreeNode target = root.left; 
        int result = minBurnTime.minBurnTime(root, target);
        System.out.println("Minimum time to burn the tree starting from target node: " + result);
    }
}
