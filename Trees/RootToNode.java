import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import apple.laf.JRSUIUtils.Tree;

public class RootToNode {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public static boolean findPath(TreeNode root, int target, List<Integer> path){
        if(root == null){
            return false;
        }
        path.add(root.val);
        if(root.val == target){
            return true;
        }
        if(findPath(root.left,target,path) || findPath(root.right,target,path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        RootToNode rootnode = new RootToNode();
        TreeNode root = rootnode.new TreeNode(1); 
        root.left = rootnode.new TreeNode(2);
        root.right = rootnode.new TreeNode(3);
        root.left.left = rootnode.new TreeNode(4);
        root.left.right = rootnode.new TreeNode(5);
        root.left.right.left = rootnode.new TreeNode(6);
        root.left.right.right = rootnode.new TreeNode(7);

        System.out.println("Enter the node value to find path from root to node:");
        int target = sc.nextInt();  

        List<Integer> path = new ArrayList<>();
        if (findPath(root, target, path)) {
            System.out.println("Path from root to node " + target + ": " + path);
        } else {
            System.out.println("Node " + target + " not found in the tree.");
        }
        sc.close();

    }
}
