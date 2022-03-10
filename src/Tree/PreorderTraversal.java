package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

    static TreeNode root;

    public static void main(String[] args) {
        PreorderTraversal treeLevel = new PreorderTraversal();
        treeLevel.root = new TreeNode(1);
        treeLevel.root.left = new TreeNode(2);
        treeLevel.root.right = new TreeNode(3);
        treeLevel.root.left.left = new TreeNode(4);
        treeLevel.root.left.right = new TreeNode(5);

        treeLevel.preorderTraversalUsingRecursion(root);
        treeLevel.preorderTraversalUsingIteration(root);
    }

    private void preorderTraversalUsingIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (true) {
            if (curr!=null) {
                System.out.println(curr.data);
                stack.add(curr);
                curr = curr.left;
            } else {
                if(stack.isEmpty()) {
                    break;
                }
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }

    private void preorderTraversalUsingRecursion(TreeNode root) {
        if (root==null) {
            return;
        }
        System.out.println(root.data);
        preorderTraversalUsingRecursion(root.left);
        preorderTraversalUsingRecursion(root.right);
    }
}
