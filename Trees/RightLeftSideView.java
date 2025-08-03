import java.util.ArrayList;
import java.util.List;

public class RightLeftSideView {
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

    public void rightSideView(TreeNode root, List<Integer> result, int level){
        if(root== null) return;
        if(result.size()== level){
            result.add(root.val);
        }
        rightSideView(root.right, result, level+1);
        rightSideView(root.left, result, level + 1);
    }

    public void leftSideView(TreeNode root, List<Integer> result,int level){
        if(root == null) return;
        if(result.size() == level){
            result.add(root.val);
        }
        leftSideView(root.left, result, level + 1);
        leftSideView(root.right, result, level + 1);
    }

    public static void main(String[] args){
        RightLeftSideView rightLeftSideView = new RightLeftSideView();
        TreeNode root = rightLeftSideView.new TreeNode(1);
        root.left = rightLeftSideView.new TreeNode(2);
        root.right = rightLeftSideView.new TreeNode(3);
        root.left.left = rightLeftSideView.new TreeNode(4);
        root.left.right = rightLeftSideView.new TreeNode(5);
        root.right.left = rightLeftSideView.new TreeNode(6);
        root.right.right = rightLeftSideView.new TreeNode(7);
        List<Integer> rightviewresult = new ArrayList<>();
        List<Integer> leftviewresult = new ArrayList<>();
        rightLeftSideView.rightSideView(root, rightviewresult, 0);
        rightLeftSideView.leftSideView(root, leftviewresult, 0);
        System.out.println("Right Side View: " + rightviewresult);
        System.out.println("Left Side View: " + leftviewresult);
        // Call methods to get right and left side views
    }
}
