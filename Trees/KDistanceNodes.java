import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KDistanceNodes {
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

    public static void parentTrack(TreeNode root, Map<TreeNode, TreeNode> parentMap, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left != null) {
                parentMap.put(current.left, current);
                q.add(current.left);
            }
            if(current.right != null) {
                parentMap.put(current.right, current);
                q.add(current.right);
            }
        }
    }

    public static List<Integer> printKDistanceNodes(TreeNode root, TreeNode target, int k, List<Integer> result) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentTrack(root,parentMap,target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.put(target, true);
        int currentlevel = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(currentlevel == k) break;
            currentlevel++;
            for(int i=0;i<size;i++){
                TreeNode current = q.poll();
                if(current.left != null && visited.get(current.left)== null){
                    q.offer(current.left);
                    visited.put(current.left, true);
                }
                if(current.right != null && visited.get(current.right)== null){
                    q.offer(current.right);
                    visited.put(current.right, true);
                }
                if(parentMap.get(current) != null && visited.get(parentMap.get(current))== null){
                    q.offer(parentMap.get(current));
                    visited.put(parentMap.get(current), true);
                }
            }
        }
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            result.add(current.val);
        }
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        KDistanceNodes tree = new KDistanceNodes();
        TreeNode root = tree.new TreeNode(3);
        root.left = tree.new TreeNode(5);
        root.right = tree.new TreeNode(1);
        root.left.left = tree.new TreeNode(6);
        root.left.right = tree.new TreeNode(2);
        root.right.right = tree.new TreeNode(4);
        root.right.left = tree.new TreeNode(8);
        root.left.right.left = tree.new TreeNode(7);
        root.left.right.right = tree.new TreeNode(9);

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();
        System.out.println("Nodes at distance " + k + " from root:");
        List<Integer> result = new ArrayList<>();
        TreeNode target = root.left;
        printKDistanceNodes(root,target, k, result);
        for(int val : result){
            System.out.print(val + " ");
        }
        System.out.println();
        sc.close();
    }
}

